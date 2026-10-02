class Solution {
    public void backtrack(int open, int close, int n, StringBuilder sb, List<String> res) {
        // base case: valid complete string
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        // choice 1: add '('
        if (open < n) {
            sb.append('(');
            backtrack(open + 1, close, n, sb, res);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
        // choice 2: add ')'
        if (close < open) {
            sb.append(')');
            backtrack(open, close + 1, n, sb, res);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(0, 0, n, new StringBuilder(), res);
        return res;
    }
}