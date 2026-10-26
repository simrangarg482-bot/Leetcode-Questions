class Solution {
    public long dfs(int i, int j, int [][] grid, boolean [][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || visited[i][j] == true) {
            return 0;
        }
        visited[i][j] = true;
        long sum = grid[i][j];
        sum += dfs(i + 1, j, grid, visited);
        sum += dfs(i - 1, j, grid, visited);
        sum += dfs(i, j + 1, grid, visited);
        sum += dfs(i, j - 1, grid, visited);
        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] > 0 && !visited[i][j]) {
                    long ans = dfs(i, j, grid, visited);
                    if(ans % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}