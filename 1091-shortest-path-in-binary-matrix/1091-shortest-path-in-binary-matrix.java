class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        // Start or destination is blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int[][] dist = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        dist[0][0] = 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            // Up
            if (row - 1 >= 0 && grid[row - 1][col] == 0 && dist[row - 1][col] == 0) {
                dist[row - 1][col] = dist[row][col] + 1;
                q.add(new int[]{row - 1, col});
            }
            // Down
            if (row + 1 < n && grid[row + 1][col] == 0 && dist[row + 1][col] == 0) {
                dist[row + 1][col] = dist[row][col] + 1;
                q.add(new int[]{row + 1, col});
            }
            // Left
            if (col - 1 >= 0 && grid[row][col - 1] == 0 && dist[row][col - 1] == 0) {
                dist[row][col - 1] = dist[row][col] + 1;
                q.add(new int[]{row, col - 1});
            }
            // Right
            if (col + 1 < n && grid[row][col + 1] == 0 && dist[row][col + 1] == 0) {
                dist[row][col + 1] = dist[row][col] + 1;
                q.add(new int[]{row, col + 1});
            }
            // Upper-left
            if (row - 1 >= 0 && col - 1 >= 0 && grid[row - 1][col - 1] == 0 && dist[row - 1][col - 1] == 0) {
                dist[row - 1][col - 1] = dist[row][col] + 1;
                q.add(new int[]{row - 1, col - 1});
            }
            // Upper-right
            if (row - 1 >= 0 && col + 1 < n && grid[row - 1][col + 1] == 0 && dist[row - 1][col + 1] == 0) {
                dist[row - 1][col + 1] = dist[row][col] + 1;
                q.add(new int[]{row - 1, col + 1});
            }
            // Lower-left
            if (row + 1 < n && col - 1 >= 0 && grid[row + 1][col - 1] == 0 && dist[row + 1][col - 1] == 0) {
                dist[row + 1][col - 1] = dist[row][col] + 1;
                q.add(new int[]{row + 1, col - 1});
            }
            // Lower-right
            if (row + 1 < n && col + 1 < n && grid[row + 1][col + 1] == 0 && dist[row + 1][col + 1] == 0) {
                dist[row + 1][col + 1] = dist[row][col] + 1;
                q.add(new int[]{row + 1, col + 1});
            }
        }
        return dist[n - 1][n - 1] == 0 ? -1 : dist[n - 1][n - 1];
    }
}