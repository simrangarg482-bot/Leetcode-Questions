class Solution {
    private void backtrack(int[] candidates, int start, int target, List<Integer> temp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        } 
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            } 
            if (candidates[i] > target) {
                break;
            } 
            temp.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], temp, result);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
       }
    }