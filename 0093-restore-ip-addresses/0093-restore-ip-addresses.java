class Solution {
    private void backtrack(String s, int index, int parts, StringBuilder sb, List<String> res) {
        // 4 parts created
        if (parts == 4) {
            if (index == s.length()) {
                res.add(sb.toString());
            }
            return;
        }
        // Try taking 1, 2, or 3 digits
        for (int len = 1; len <= 3; len++) {
            // Not enough characters left
            if (index + len > s.length()) {
                break;
            }
            String part = s.substring(index, index + len);
            // Leading zero
            if (part.length() > 1 && part.charAt(0) == '0') {
                continue;
            }
            // Value must be <= 255
            int value = Integer.parseInt(part);
            if (value > 255) {
                continue;
            }
            // Choose
            sb.append(part);
            if (parts < 3) {
                sb.append('.');
            }
            // Explore
            backtrack(s, index + len, parts + 1, sb, res);
            // Undo
            if (parts < 3) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.delete(sb.length() - part.length(), sb.length());
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        backtrack(s, 0, 0, new StringBuilder(), res);
        return res;
    }
}