class Solution {
    public int minDays(int n) {

        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int[] velquorani = {n};

        for (int score = 0; score <= n; score++) {

            if (dp[score] == Integer.MAX_VALUE) {
                continue;
            }

            int sum = 0;

            for (int streak = 1; score + sum <= n; streak++) {

                sum += streak;

                if (score + sum > n) {
                    break;
                }

                // Start a new streak.
                // If this is not the first streak, one skipped day is needed.
                int extraDay = (score == 0) ? 0 : 1;

                dp[score + sum] =
                    Math.min(dp[score + sum],
                             dp[score] + streak + extraDay);
            }
        }

        return dp[n];
    }
}