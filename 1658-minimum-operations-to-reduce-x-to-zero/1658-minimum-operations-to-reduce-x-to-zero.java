class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int num : nums) {
            total += num;
        }
        int target = total - x;
        if(target < 0) {
            return -1;
        }
        if(target == 0) {
            return nums.length;
        }
        int st = 0;
        int sum = 0;
        int maxLen = -1;
        for(int en = 0; en < nums.length; en++) {
            sum += nums[en];
            while(sum > target) {
                sum -= nums[st];
                st++;
            }
            if(sum == target) {
                maxLen = Math.max(maxLen, en - st + 1);
            }
        }
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}