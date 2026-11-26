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
    public void bfs(int i, int j, int [][] ans, int color, int original, boolean [][] vis, int [][] image) {
        int m = ans.length;
        int n = ans[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        while(q.size() > 0) {
            Pair front = q.poll();
            int r = front.row;
            int c = front.col;
            if(r-1 >= 0 && image[r-1][c] == original && !vis[r-1][c]) {
                q.add(new Pair(r-1, c));
                ans[r-1][c] = color;
                vis[r-1][c] = true;
            }
            if(c-1 >= 0 && image[r][c-1] == original && !vis[r][c-1]) {
                q.add(new Pair(r, c-1));
                ans[r][c-1] = color;
                vis[r][c-1] = true;
            }
            if(r+1 < m && image[r+1][c] == original && !vis[r+1][c]) {
                q.add(new Pair(r+1, c));
                ans[r+1][c] = color;
                vis[r+1][c] = true;
            }
            if(c+1 < n && image[r][c+1] == original && !vis[r][c+1]) {
                q.add(new Pair(r, c+1));
                ans[r][c+1] = color;
                vis[r][c+1] = true;
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean [][] vis = new boolean[m][n];
        int [][] ans = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                ans[i][j] = image[i][j];
            }
        }
        int original = image[sr][sc];
        ans[sr][sc] = color;
        vis[sr][sc] = true;
        bfs(sr, sc, ans, color, original, vis, image);
        return ans;
    }
}