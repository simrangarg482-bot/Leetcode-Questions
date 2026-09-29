class Solution {
    public int backtrack(String s, int index, int[] dp) {
        if (index == s.length()) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int min = Integer.MAX_VALUE;
        // Try every possible partition
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                // Number of cuts: 1 cut for choosing this palindrome
                int cuts = 1 + backtrack(s, i + 1, dp);
                min = Math.min(min, cuts);
            }
        }
        dp[index] = min;
        return dp[index];
    }
    boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return backtrack(s, 0, dp) - 1;
    }
}