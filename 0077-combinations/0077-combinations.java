class Solution {

    public void backtrack(int start, int n, int k, List<Integer> temp, List<List<Integer>> res) {
        
        // base case
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // try all choices from "start to n"
        for (int i = start; i <= n; i++) {
            
            // choose
            temp.add(i);

            // explore
            backtrack(i + 1, n, k, temp, res);

            // un-choose (backtrack)
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        backtrack(1, n, k, temp, res);

        return res;
    }
}