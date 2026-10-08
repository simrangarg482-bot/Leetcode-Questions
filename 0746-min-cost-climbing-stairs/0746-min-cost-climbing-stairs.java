class Solution {
    public int helper(int idx, int [] cost, int [] dp) {
        if(idx >= cost.length) {
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];
        int take = cost[idx] + helper(idx+1, cost, dp);
        int not_take = cost[idx] + helper(idx+2, cost, dp);
        return dp[idx] = Math.min(take, not_take);
    }
    public int minCostClimbingStairs(int[] cost) {
        int [] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(helper(0, cost, dp), helper(1, cost, dp));
    }
}