class Solution {
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int [] nums, int start) {
        if(result.contains(temp)) return;
        result.add(new ArrayList<>(temp));
        for(int i=start; i<nums.length; i++) {
            temp.add(nums[i]);
            backtrack(result, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
}