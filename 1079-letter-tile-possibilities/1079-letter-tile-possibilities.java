class Solution {

    public void helper(String tiles, boolean [] used, HashSet<String> result, String curr) {
        int n = tiles.length();
        result.add(curr);
        for(int i=0; i<n; i++) {
            if(used[i]) continue;
            used[i] = true;
            curr += tiles.charAt(i);
            helper(tiles, used, result, curr);
            used[i] = false;
            curr = curr.substring(0, curr.length()-1);      
        }
    }

    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        boolean [] used = new boolean[n];
        HashSet<String> result = new HashSet<>();
        String curr = "";
        helper(tiles, used, result, curr);
        return result.size()-1;
    }
}