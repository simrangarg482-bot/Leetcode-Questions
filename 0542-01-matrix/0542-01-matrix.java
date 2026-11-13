// mark all the labels infinite in the array then for each value only look at top and to the right of the matrix to check for the nearest 0, now fill the actual value with the minimum of right and bottom cell 
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length; 
        int [][] result = new int[rows][cols];

        // initialize the result matrix with the maximum values (as we said, fill the result matrix with infinite first) 
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        // first pass: top-left to bottom-right 
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(mat[i][j] == 0) result[i][j] = 0; 
                else {
                    if(i > 0 && result[i - 1][j] != Integer.MAX_VALUE) result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                    if(j > 0 && result[i][j - 1] != Integer.MAX_VALUE) result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                }
            }
        }

        // second pass: bottom-right to top-left 
        for(int i= rows-1; i>=0; i--) {
            for(int j= cols-1; j>=0; j--) {
                if(mat[i][j] != 0) {
                    if(i < rows-1 && result[i + 1][j] != Integer.MAX_VALUE) result[i][j] = Math.min(result[i][j], result[i+1][j] + 1);
                    if(j < cols-1 && result[i][j + 1] != Integer.MAX_VALUE) result[i][j] = Math.min(result[i][j], result[i][j+1] + 1);
                }
            }
        }
        return result;  
    }
}