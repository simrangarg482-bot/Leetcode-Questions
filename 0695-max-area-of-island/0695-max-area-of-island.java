// using bfs
class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int bfs(int i, int j, int [][] grid, boolean [][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        vis[i][j] = true;
        while(q.size() > 0) {
            Pair front = q.poll();
            int r = front.row;
            int c = front.col;
            if(r-1 >= 0 && !vis[r-1][c] && grid[r-1][c] == 1) {
                q.add(new Pair(r-1, c));
                vis[r-1][c] = true;
                count++;
            }
            if(c-1 >= 0 && !vis[r][c-1] && grid[r][c-1] == 1) {
                q.add(new Pair(r, c-1));
                vis[r][c-1] = true;
                count++;
            }
            if(r+1 < m && !vis[r+1][c] && grid[r+1][c] == 1) {
                q.add(new Pair(r+1, c));
                vis[r+1][c] = true;
                count++;
            }
            if(c+1 < n && !vis[r][c+1] && grid[r][c+1] == 1) {
                q.add(new Pair(r, c+1));
                vis[r][c+1] = true;
                count++;
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] vis = new boolean[m][n];
        int max = 0;
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    count = bfs(i, j, grid, vis);
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}