class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            // If current character is an operator
            if(ch == '+' || ch == '-' || ch == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                // Get all possible results from left side
                List<Integer> leftResults = diffWaysToCompute(left);
                // Get all possible results from right side
                List<Integer> rightResults = diffWaysToCompute(right);
                // Combine every left result with every right result
                for(int l : leftResults) {
                    for(int r : rightResults) {
                        if(ch == '+') ans.add(l + r);
                        else if(ch == '-') ans.add(l - r);
                        else ans.add(l * r);
                    }
                }
            }
        }
        // No operator means expression is just a number
        if(ans.size() == 0) {
            ans.add(Integer.parseInt(expression));
        }
        return ans;
    }
}