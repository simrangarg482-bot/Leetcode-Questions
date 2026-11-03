class Solution {
    int ans = 0;
    public void backtrack(int[] nums, int target, int start, int index, int count) {
        if (index == nums.length) {
            return;
        }
        if (nums[index] == target) {
            count++;
        }
        int len = index - start + 1;
        if (count * 2 > len) {
            ans++;
        }
        backtrack(nums, target, start, index + 1, count);
    }
    public int countMajoritySubarrays(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            backtrack(nums, target, i, i, 0);
        }
        return ans;
    }
}
