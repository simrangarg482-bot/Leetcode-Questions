class Solution {
    public int checkRecord(int n) {
        final int MOD = 1_000_000_007;
        // dp[a][l]:
        // a = absences used (0 or 1)
        // l = consecutive late days at the end (0, 1, or 2)
        int[][] dp = new int[2][3];
        // One way to create an empty record.
        dp[0][0] = 1;
        for (int day = 1; day <= n; day++) {
            int[][] next = new int[2][3];
            for (int a = 0; a <= 1; a++) {
                for (int l = 0; l <= 2; l++) {
                    int ways = dp[a][l];
                    if (ways == 0) {
                        continue;
                    }
                    // Choice 1: Append P. Present resets the late streak.
                    next[a][0] = (int) ((next[a][0] + (long) ways) % MOD);
                    // Choice 2: Append A, if none used before.
                    if (a == 0) {
                        next[1][0] = (int) ((next[1][0] + (long) ways) % MOD);
                    }
                    // Choice 3: Append L, if fewer than 2 consecutive late days so far.
                    if (l < 2) {
                        next[a][l + 1] = (int) ((next[a][l + 1] + (long) ways) % MOD);
                    }
                }
            }
            dp = next;
        }
        long answer = 0;
        for (int a = 0; a <= 1; a++) {
            for (int l = 0; l <= 2; l++) {
                answer = (answer + dp[a][l]) % MOD;
            }
        }
        return (int) answer;
    }
}