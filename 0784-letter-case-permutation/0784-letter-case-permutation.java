class Solution {

    public void backtrack(char[] arr, int index, List<String> res) {

        // base case: processed full string
        if (index == arr.length) {
            res.add(new String(arr));
            return;
        }

        char ch = arr[index];

        // if digit → only one path
        if (Character.isDigit(ch)) {
            backtrack(arr, index + 1, res);
        } 
        else {
            // choice 1: lowercase
            arr[index] = Character.toLowerCase(ch);
            backtrack(arr, index + 1, res);

            // choice 2: uppercase
            arr[index] = Character.toUpperCase(ch);
            backtrack(arr, index + 1, res);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s.toCharArray(), 0, res);
        return res;
    }
}