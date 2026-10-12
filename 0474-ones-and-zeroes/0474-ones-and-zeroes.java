class Solution {
    public int helper(int idx, String[] strs, int m, int n, int[][][] dp) {
        if (idx == strs.length) {
            return 0;
        }
        if (dp[idx][m][n] != -1) {
            return dp[idx][m][n];
        }
        int zero = 0;
        int one = 0;
        String s = strs[idx];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                zero++;
            } else {
                one++;
            }
        }
        int skip = helper(idx + 1, strs, m, n, dp);
        int take = 0;
        if (zero <= m && one <= n) {
            take = 1 + helper(idx + 1, strs, m - zero, n - one, dp);
        }
        return dp[idx][m][n] = Math.max(take, skip);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return helper(0, strs, m, n, dp);
    }
}