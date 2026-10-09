class Solution {
    public int helper(int i, int[] points, int [] dp) {
        if (i >= points.length) {
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        int take = points[i] + helper(i + 2, points, dp);
        int notTake = helper(i + 1, points, dp);
        return dp[i] = Math.max(take, notTake);
    }
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }
        int[] points = new int[max + 1];
        for (int i : nums) {
            points[i] = points[i] + i;
        }
        int [] dp = new int[points.length];
        for(int i=0; i<points.length; i++) {
            Arrays.fill(dp, -1);
        }
        return helper(0, points, dp);
    }
}