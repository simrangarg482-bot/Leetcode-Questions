class Solution {
    public int maxDepth(String s) {
        int max = 0;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push(s.charAt(i));
                int len = st.size();
                max = Math.max(max, len);
            } else if(s.charAt(i) == ')') {
                st.pop();
            }
        }
        return max;
    }
}