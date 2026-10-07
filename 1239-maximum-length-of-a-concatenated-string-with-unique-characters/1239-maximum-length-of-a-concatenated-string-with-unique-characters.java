class Solution {
    public int helper(int idx, List<String> arr, HashSet<Character> set, int len) {
        // Base case
        if (idx == arr.size()) {
            return len;
        }
        // Option 1: Don't take the current string
        int max = helper(idx + 1, arr, set, len);
        String st = arr.get(idx);
        // Check whether we can take this string
        boolean valid = true;
        for (int j = 0; j < st.length(); j++) {
            char ch = st.charAt(j);
            // Character already exists
            if (set.contains(ch)) {
                valid = false;
                break;
            }
            // Duplicate character inside the current string
            if (st.indexOf(ch) != j) {
                valid = false;
                break;
            }
        }
        // Option 2: Take the current string
        if (valid) {
            // Add characters to set
            for (int j = 0; j < st.length(); j++) {
                set.add(st.charAt(j));
            }
            // Recurse
            int take = helper(idx + 1, arr, set, len + st.length());
            // Update maximum
            max = Math.max(max, take);
            // Backtrack: remove characters
            for (int j = 0; j < st.length(); j++) {
                set.remove(st.charAt(j));
            }
        }
        return max;
    }
    public int maxLength(List<String> arr) {
        HashSet<Character> set = new HashSet<>();
        return helper(0, arr, set, 0);
    }
}