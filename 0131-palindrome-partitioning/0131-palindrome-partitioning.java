class Solution {
    private void backtrack(int index, String s, List<String> temp, List<List<String>> result) { 
        if (index == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
             if (isPalindrome(s, index, i)) {
                 temp.add(s.substring(index, i + 1)); 
                 backtrack(i + 1, s, temp, result);
                 temp.remove(temp.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }
}