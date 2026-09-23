class Solution {
    private boolean helper(String curr, Map<String, List<Character>> mp, int idx, StringBuilder above) {
        // We reached the top of the pyramid
        if (curr.length() == 1) {
            return true;
        }
        // Finished constructing the next level
        if (idx == curr.length() - 1) {
            return helper(above.toString(), mp, 0, new StringBuilder());
        }
        // Take the current pair
        String pair = curr.substring(idx, idx + 2);
        // No possible character can be placed above this pair
        if (!mp.containsKey(pair)) {
            return false;
        }
        // Try every possible character
        for (char ch : mp.get(pair)) {
            // DO: choose
            above.append(ch);
            // EXPLORE
            if (helper(curr, mp, idx + 1, above)) {
                return true;
            }
            // UNDO: backtrack
            above.deleteCharAt(above.length() - 1);
        }
        return false;
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> mp = new HashMap<>();
        // Build the mapping:
        // "ABC" -> "AB" can produce 'C'
        for (String pattern : allowed) {
            String pair = pattern.substring(0, 2);
            char ch = pattern.charAt(2);
            if (!mp.containsKey(pair)) {
                mp.put(pair, new ArrayList<>());
            }
            mp.get(pair).add(ch);
        }
        return helper(bottom, mp, 0, new StringBuilder());
    }
}