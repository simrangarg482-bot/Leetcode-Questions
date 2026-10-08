class Solution {
   public int helper(int idx, int n, int [] dp) {
        if(idx == n) {
            return 1;
        }
        if(idx > n) {
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];
        int oneStep = helper(idx + 1, n, dp);
        int twoStep = helper(idx + 2, n, dp);
        return dp[idx] = oneStep + twoStep;
    }
    public int climbStairs(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(0, n, dp);
    }
}