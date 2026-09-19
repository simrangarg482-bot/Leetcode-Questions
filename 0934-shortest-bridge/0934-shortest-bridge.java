class Solution {
    public void dfs(int row, int col, int[][] grid, Queue<int[]> q) {
        int n = grid.length;
        if (row < 0 || row >= n || col < 0 || col >= n || grid[row][col] != 1) {
            return;
        }
        grid[row][col] = 2;
        q.add(new int[]{row, col});
        dfs(row - 1, col, grid, q);
        dfs(row + 1, col, grid, q);
        dfs(row, col - 1, grid, q);
        dfs(row, col + 1, grid, q);
    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        // Find the first island
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, q);
                    found = true;
                    break;
                }
            }
        }
        int distance = 0;
        // Multi-source BFS
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                // Up
                if (row - 1 >= 0) {
                    if (grid[row - 1][col] == 1) {
                        return distance;
                    }
                    if (grid[row - 1][col] == 0) {
                        grid[row - 1][col] = 2;
                        q.add(new int[]{row - 1, col});
                    }
                }
                // Down
                if (row + 1 < n) {
                    if (grid[row + 1][col] == 1) {
                        return distance;
                    }
                    if (grid[row + 1][col] == 0) {
                        grid[row + 1][col] = 2;
                        q.add(new int[]{row + 1, col});
                    }
                }
                // Left
                if (col - 1 >= 0) {
                    if (grid[row][col - 1] == 1) {
                        return distance;
                    }
                    if (grid[row][col - 1] == 0) {
                        grid[row][col - 1] = 2;
                        q.add(new int[]{row, col - 1});
                    }
                }
                // Right
                if (col + 1 < n) {
                    if (grid[row][col + 1] == 1) {
                        return distance;
                    }
                    if (grid[row][col + 1] == 0) {
                        grid[row][col + 1] = 2;
                        q.add(new int[]{row, col + 1});
                    }
                }
            }
            distance++;
        }
        return -1;
    }
}