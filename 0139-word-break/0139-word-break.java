class Solution {
    public boolean helper(int idx, String s, HashSet<String> set, Boolean[] dp) {
        if(idx >= s.length()) {
            return true;
        }
        if(dp[idx] != null) {
            return dp[idx];
        }
        for(int i = idx + 1; i <= s.length(); i++) {
            String temp = s.substring(idx, i);
            if(set.contains(temp) && helper(i, s, set, dp)) {
                return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String str : wordDict) {
            set.add(str);
        }
        Boolean[] dp = new Boolean[s.length()];
        return helper(0, s, set, dp);
    }
}