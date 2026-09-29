class Solution {
    public int helper(int idx, int[] nums, int target, int[][] dp) {
        if (target == 0) return 1;
        if (idx >= nums.length || target < 0) return 0;
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }
        int take_idx = helper(0, nums, target - nums[idx], dp);
        int reject_idx = helper(idx + 1, nums, target, dp);
        return dp[idx][target] = take_idx + reject_idx;
    }
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, nums, target, dp);
    }
}