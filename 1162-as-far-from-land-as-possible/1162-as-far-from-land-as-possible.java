class Solution {
    public int maxDistance(int[][] grid) {
        int m =  grid.length;
        int n = grid[0].length;
        int [][] result = new int[m][n];
        Queue<int []> q = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    result[i][j] = 0;
                    q.add(new int[]{i, j});
                } else {
                    result[i][j] = -1;
                }
            }
        }
        while(q.size() > 0) {
            int [] front = q.poll();
            int r = front[0];
            int c = front[1];
            if(r+1 < m && result[r+1][c] == -1) {
                result[r+1][c] = result[r][c] + 1;
                q.add(new int[]{r+1, c});
            }
            if(r-1 >= 0 && result[r-1][c] == -1) {
                result[r-1][c] = result[r][c] + 1;
                q.add(new int[]{r-1, c});
            }
            if(c+1 < n && result[r][c+1] == -1) {
                result[r][c+1] = result[r][c] + 1;
                q.add(new int[]{r, c+1});
            }
            if(c-1 >= 0 && result[r][c-1] == -1) {
                result[r][c-1] = result[r][c] + 1;
                q.add(new int[]{r, c-1});
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<result.length; i++) {
            for(int j=0; j<result[0].length; j++) {
                max = Math.max(max, result[i][j]);
            }
        }
        return (max == 0)?-1:max;
    }
}