class Solution {
    List<String> ans = new ArrayList<>();
    public void backtrack(String s, int index, int removeOpen, int removeClose, String current) {
        if (index == s.length()) {
            if (removeOpen == 0 && removeClose == 0 && isValid(current)) {
                if (!ans.contains(current)) {
                    ans.add(current);
                }
            }
            return;
        }
        char ch = s.charAt(index);
        // OPTION 1: remove this parenthesis
        if (ch == '(' && removeOpen > 0) {
            backtrack(s, index + 1, removeOpen - 1, removeClose, current);
        }
        if (ch == ')' && removeClose > 0) {
            backtrack(s, index + 1, removeOpen, removeClose - 1, current);
        }
        // OPTION 2: keep this character
        backtrack(s, index + 1, removeOpen, removeClose, current + ch);
    }
    public boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            else if (s.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
    public List<String> removeInvalidParentheses(String s) {
        int open = 0;
        int removeClose = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            }
            else if (s.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                } 
                else {
                    removeClose++;
                }
            }
        }
        backtrack(s, 0, open, removeClose, "");
        return ans;
    }
}