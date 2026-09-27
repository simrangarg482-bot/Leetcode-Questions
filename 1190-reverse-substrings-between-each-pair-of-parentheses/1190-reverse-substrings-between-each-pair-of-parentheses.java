class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                // Save the string built before '('
                st.push(res.toString());
                // Start a new substring
                res = new StringBuilder();
            }
            else if(ch == ')') {
                // Reverse the substring inside parentheses
                res.reverse();
                // Add it to the previous part
                res.insert(0, st.pop());
            }
            else {
                // Normal character
                res.append(ch);
            }
        }
        return res.toString();
    }
}