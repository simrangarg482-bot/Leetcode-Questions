class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        // {row, col, cost}
        q.addFirst(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            int row = current[0];
            int col = current[1];
            int cost = current[2];
            if (visited[row][col]) continue;
            visited[row][col] = true;
            // Reached bottom-right
            if (row == m - 1 && col == n - 1) return cost;
            // Try all 4 directions
            for (int k = 0; k < 4; k++) {
                int newRow = row + directions[k][0];
                int newCol = col + directions[k][1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    // k = 0 means right
                    // k = 1 means left
                    // k = 2 means down
                    // k = 3 means up
                    int direction = k + 1;
                    if (grid[row][col] == direction) {
                        // Following arrow → cost 0
                        q.addFirst(new int[]{newRow, newCol, cost});
                    } else {
                        // Changing arrow → cost 1
                        q.addLast(new int[]{newRow,newCol, cost + 1});
                    }
                }
            }
        }
        return -1;
    }
}