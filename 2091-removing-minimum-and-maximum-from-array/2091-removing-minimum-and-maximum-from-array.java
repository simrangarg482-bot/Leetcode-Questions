class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        int first = Math.min(minIndex, maxIndex);
        int last = Math.max(minIndex, maxIndex);

        // Both deleted from the left
        int bothLeft = last + 1;

        // Both deleted from the right
        int bothRight = n - first;

        // first deleted from left, last deleted from right
        int leftRight = (first + 1) + (n - last);

        // last deleted from left, first deleted from right
        int rightLeft = (last + 1) + (n - first);

        return Math.min(
            Math.min(bothLeft, bothRight),
            Math.min(leftRight, rightLeft)
        );
    }
}