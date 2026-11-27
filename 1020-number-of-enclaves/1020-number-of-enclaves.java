class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];

        // Add all boundary 1's to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (grid[i][j] == 1) {
                        q.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }
        // BFS
        while (!q.isEmpty()) {

            Pair front = q.poll();

            int r = front.first;
            int c = front.second;

            // UP
            if (r - 1 >= 0 && grid[r - 1][c] == 1 && vis[r - 1][c] == 0) {

                q.add(new Pair(r - 1, c));
                vis[r - 1][c] = 1;
            }

            // RIGHT
            if (c + 1 < n && grid[r][c + 1] == 1 && vis[r][c + 1] == 0) {

                q.add(new Pair(r, c + 1));
                vis[r][c + 1] = 1;
            }

            // DOWN
            if (r + 1 < m && grid[r + 1][c] == 1 && vis[r + 1][c] == 0) {

                q.add(new Pair(r + 1, c));
                vis[r + 1][c] = 1;
            }

            // LEFT
            if (c - 1 >= 0 && grid[r][c - 1] == 1 && vis[r][c - 1] == 0) {

                q.add(new Pair(r, c - 1));
                vis[r][c - 1] = 1;
            }
        }

        // Count unvisited land cells
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}