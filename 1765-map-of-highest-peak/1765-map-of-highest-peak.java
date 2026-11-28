class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = -1;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        // Put ALL water cells into queue initially
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    result[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                    continue;
                }
                // Already visited
                if (result[nr][nc] != -1) {
                    continue;
                }
                result[nr][nc] = result[r][c] + 1;
                queue.add(new int[]{nr, nc});
            }
        }
        return result;
    }
}