class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                if(st.size() == 0) {
                    st.push(ch);
                } else if(st.size() > 0 && st.peek() == '(') {
                    st.push(ch);
                    sb.append(ch);
                } 
            } else if(st.size() > 1 && st.peek() == '(' && ch == ')') {
                sb.append(ch);
                st.pop();
            } else if(st.size() > 0 && st.peek() == '(' && ch == ')') {
                st.pop();
            }
        }
        return sb.toString();
    }
}