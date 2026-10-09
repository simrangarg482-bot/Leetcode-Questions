class Solution {
    public int helper(int idx, String s, int[] dp) {
        // We have decoded the entire string successfully
        if (idx == s.length()) {
            return 1;
        }
        // A number cannot start with 0
        if (s.charAt(idx) == '0') {
            return 0;
        }
        // Have we already calculated the answer for this index?
        if (dp[idx] != -1) return dp[idx];
        // Choice 1: Decode one digit
        int ways = helper(idx + 1, s, dp);
        // Choice 2: Decode two digits, if possible
        if (idx + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(idx, idx + 2));
            if (num >= 10 && num <= 26) {
                ways += helper(idx + 2, s, dp);
            }
        }
        return dp[idx] = ways;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(0, s, dp);
    }
}