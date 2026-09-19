class Solution {
    public int[] dfs(int[][] land, int row, int col) {
        int m = land.length;
        int n = land[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || land[row][col] != 1) {
            return new int[]{row - 1, col - 1};
        }
        land[row][col] = 0;
        int[] down = dfs(land, row + 1, col);
        int[] right = dfs(land, row, col + 1);
        return new int[]{Math.max(down[0], right[0]), Math.max(down[1], right[1])};
    }

    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int[] end = dfs(land, i, j);
                    result.add(new int[]{i, j, end[0], end[1]});
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}