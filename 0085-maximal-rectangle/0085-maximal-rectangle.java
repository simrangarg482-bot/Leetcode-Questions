class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] height = new int[cols];
        int[] left = new int[cols];
        int[] right = new int[cols];
        Arrays.fill(right, cols);
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            int currentLeft = 0;
            int currentRight = cols;
            // Update heights
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            // Update left boundaries
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], currentLeft);
                } else {
                    left[j] = 0;
                    currentLeft = j + 1;
                }
            }
            // Update right boundaries
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], currentRight);
                } else {
                    right[j] = cols;
                    currentRight = j;
                }
            }
            // Calculate maximum area
            for (int j = 0; j < cols; j++) {
                int area = height[j] * (right[j] - left[j]);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}