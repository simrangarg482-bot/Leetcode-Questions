class Solution {
    class Pair {
        int row; 
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    private void bfs(int row, int column, char [][] grid, boolean [][] vis) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length; 
        int n = grid[0].length; 
        q.add(new Pair(row, column));
        vis[row][column] = true;
        while(q.size()>0) {
            Pair front = q.remove();
            int r = front.row;
            int c = front.col; 
            // top -> row-1, col
            if((r-1)>=0) {
                if(!vis[r-1][c] && grid[r-1][c] == '1') {
                    q.add(new Pair(r-1,c));
                    vis[r-1][c] = true;
                }
            }
            // bottom -> row+1, col
            if((r+1)<m) {
                if(!vis[r+1][c] && grid[r+1][c] == '1') {
                    q.add(new Pair(r+1,c));
                    vis[r+1][c] = true;
                }
            }
            // left -> row, col-1
            if((c-1)>=0) {
                if(!vis[r][c-1] && grid[r][c-1] == '1') {
                    q.add(new Pair(r,c-1));
                    vis[r][c-1] = true;
                }
            }
            // right -> row, col+1
            if((c+1)<n) {
                if(!vis[r][c+1] && grid[r][c+1] == '1') {
                    q.add(new Pair(r,c+1));
                    vis[r][c+1] = true;
                }
            }
        }
    }
    private void dfs(int i, int j, char [][] grid, boolean [][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        vis[i][j] = true;
        if((i-1)>=0 && grid[i-1][j] == '1' && !vis[i-1][j]) dfs(i-1, j, grid, vis);
        if((i+1)<m && grid[i+1][j] == '1' && !vis[i+1][j]) dfs(i+1, j, grid, vis);
        if((j-1)>=0 && grid[i][j-1] == '1' && !vis[i][j-1]) dfs(i, j-1, grid, vis);
        if((j+1)<n && grid[i][j+1] == '1' && !vis[i][j+1]) dfs(i, j+1, grid, vis);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 
        int count = 0;
        boolean [][] vis = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    //bfs(i, j, grid, vis); 
                    dfs(i, j, grid, vis); 
                        count++;
                }
            }
        }
        return count;
    }
}