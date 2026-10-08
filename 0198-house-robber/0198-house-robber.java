class Solution {
    public int helper(int idx, int[] nums, int[] dp) {
        if(idx >= nums.length) {
            return 0;
        }
        if(dp[idx] != -1) {
            return dp[idx];
        }
        int rob = nums[idx] + helper(idx + 2, nums, dp);
        int notRob = helper(idx + 1, nums, dp);
        return dp[idx] = Math.max(rob, notRob);
    }
    public int rob(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    return helper(0, nums, dp);
}
}