class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void dfs(int[][] heights, int r, int c, int prevCellVal, boolean[][] visited) {
        int m = heights.length;
        int n = heights[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return;
        }
        // Already visited OR cannot flow in this direction
        if (visited[r][c] || heights[r][c] < prevCellVal) {
            return;
        }
        visited[r][c] = true;
        // Visit all 4 directions
        for (int[] dir : directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfs(heights, newR, newC, heights[r][c], visited);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];
        // Pacific Ocean
        // Top row
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, heights[0][j], pacificVisited);
        }
        // Left column
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, heights[i][0], pacificVisited);
        }
        // Atlantic Ocean
        // Bottom row
        for (int j = 0; j < n; j++) {
            dfs(heights, m - 1, j, heights[m - 1][j], atlanticVisited);
        }
        // Right column
        for (int i = 0; i < m; i++) {
            dfs(heights, i, n - 1, heights[i][n - 1], atlanticVisited);
        }
        // Cells that can reach BOTH oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
}