class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        // Not enough jobs to give every day at least one job.
        if (n < d) return -1;
        int INF = 1_000_000_000;
        // dp[day][i] = minimum difficulty for first i jobs completed in exactly 'day' days.
        int[][] dp = new int[d + 1][n + 1];
        for (int day = 0; day <= d; day++) {
            for (int i = 0; i <= n; i++) {
                dp[day][i] = INF;
            }
        }
        // Zero jobs in zero days costs zero.
        dp[0][0] = 0;
        for (int day = 1; day <= d; day++) {
            for (int i = day; i <= n; i++) {
                int maxDifficulty = 0;
                // Try every possible start index of the last day.
                for (int j = i - 1; j >= day - 1; j--) {
                    maxDifficulty = Math.max(maxDifficulty, jobDifficulty[j]);
                    if (dp[day - 1][j] != INF) {
                        dp[day][i] = Math.min(dp[day][i], dp[day - 1][j] + maxDifficulty);
                    }
                }
            }
        }
        return dp[d][n];
    }
}