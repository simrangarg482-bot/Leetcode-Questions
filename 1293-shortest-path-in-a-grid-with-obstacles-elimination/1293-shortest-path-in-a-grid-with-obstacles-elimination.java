class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][k + 1];
        q.add(new int[]{0, 0, k});
        visited[0][0][k] = true;
        int steps = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] current = q.poll();
                int row = current[0];
                int col = current[1];
                int remaining = current[2];
                if (row == m - 1 && col == n - 1) {
                    return steps;
                }
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                        continue;
                    }
                    int newRemaining = remaining;
                    if (grid[newRow][newCol] == 1) {
                        newRemaining--;
                    }
                    if (newRemaining < 0) {
                        continue;
                    }
                    if (!visited[newRow][newCol][newRemaining]) {
                        visited[newRow][newCol][newRemaining] = true;
                        q.add(new int[]{newRow, newCol, newRemaining});
                    }
                }
                size--;
            }
            steps++;
        }
        return -1;
    }
}