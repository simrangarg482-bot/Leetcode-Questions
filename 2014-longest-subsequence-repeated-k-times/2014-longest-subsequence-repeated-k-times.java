class Solution {
    private String backtrack(String s, int k, String possible, String curr, int maxLen) {
        if (curr.length() == maxLen) {
            return curr;
        }
        String best = curr;
        for (int i = 0; i < possible.length(); i++) {
            char ch = possible.charAt(i);
            String next = curr + ch;
            if (!isValid(s, next, k)) {
                continue;
            }
            String candidate = backtrack(s, k, possible, next, maxLen);
            if (candidate.length() > best.length() || (candidate.length() == best.length() && candidate.compareTo(best) > 0)) {
                best = candidate;
            }
        }
        return best;
    }
    
    private boolean isValid(String s, String sub, int k) {
        int index = 0;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == sub.charAt(index)) {
                index++;
                if (index == sub.length()) {
                    count++;
                    if (count == k) {
                        return true;
                    }
                    index = 0;
                }
            }
        }
        return false;
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder possible = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            if (freq[i] >= k) {
                possible.append((char) ('a' + i));
            }
        }
        int maxLen = s.length() / k;
        return backtrack(s, k, possible.toString(), "", maxLen);
    }
}