class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int left = 0;
        int right = nums.length-1;
        int ind = (left + right)/2;
        int mid = nums[ind];
        for(int i=0; i<nums.length; i++) {
            int diff = Math.abs(nums[i] - mid);
            res += diff;
        }
        return res;
    }
}