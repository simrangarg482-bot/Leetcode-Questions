class Solution {
    private int helper(int i, int j, int[][] dungeon, int[][] dp) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // Outside the grid: invalid path
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE / 2;
        }
        // Destination
        if (i == m - 1 && j == n - 1) {
            return Math.max(1, 1 - dungeon[i][j]);
        }
        if (dp[i][j] != -1) return dp[i][j];
        // Minimum health required from the next cell
        int right = helper(i, j + 1, dungeon, dp);
        int down = helper(i + 1, j, dungeon, dp);
        int nextHealth = Math.min(right, down);
        // Health required before entering current cell
        return dp[i][j] = Math.max( 1, nextHealth - dungeon[i][j]);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(0, 0, dungeon, dp);
    }
}