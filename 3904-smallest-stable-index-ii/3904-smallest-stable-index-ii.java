class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        // max(nums[0..i])
        leftMax[0] = nums[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }
        // min(nums[i..n-1])
        rightMin[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }
        // Find first stable index
        for(int i = 0; i < n; i++) {
            int diff = leftMax[i] - rightMin[i];
            if(diff <= k) {
                return i;
            }
        }
        return -1;
    }
}