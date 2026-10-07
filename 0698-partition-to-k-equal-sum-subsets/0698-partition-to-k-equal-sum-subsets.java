class Solution {
    public boolean helper(int idx, int[] nums, int[] help, int target) {
        if (idx == nums.length) {
            return true;
        }
        int num = nums[idx];
        for (int i = 0; i < help.length; i++) {
            if (help[i] + num > target) {
                continue;
            }
            // If two buckets currently have the same sum, trying both gives the same result.
            if (i > 0 && help[i] == help[i - 1]) {
                continue;
            }
            // CHOOSE
            help[i] += num;
            if (helper(idx + 1, nums, help, target)) {
                return true;
            }
            // UNDO
            help[i] -= num;
            // If this bucket was empty, and putting num here didn't work, don't try other empty buckets.
            if (help[i] == 0) {
                break;
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % k != 0) {
            return false;
        }
        int target = total / k;
        Arrays.sort(nums);
        // Largest numbers first
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        if (nums[0] > target) {
            return false;
        }
        int[] help = new int[k];
        return helper(0, nums, help, target);
    }
}