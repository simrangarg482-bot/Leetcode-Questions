class Solution {
    Boolean [] dp;
    public boolean helper(int idx, String s, List<String> wordDict, Boolean[] dp) {
        if(idx >= s.length()) return true;
        if(dp[idx] != null) return dp[idx];
        for (int end = idx + 1; end <= s.length(); end++) {
            String str = s.substring(idx, end);
            if(wordDict.contains(str)) {
                if(helper(end, s, wordDict, dp)) {
                    return dp[idx] = true;
                }
            }
        }
        return dp[idx] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()]; 
        return helper(0, s, wordDict, dp);
    }
}