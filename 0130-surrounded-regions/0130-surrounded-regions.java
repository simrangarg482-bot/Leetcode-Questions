class Solution {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void dfs(int r, int c, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n ||
            board[r][c] != 'O') {
            return;
        }
        board[r][c] = '#';
        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            dfs(nr, nc, board);
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        // Start DFS from boundary O's
        for (int i = 0; i < m; i++) {
            dfs(i, 0, board);
            dfs(i, n - 1, board);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, board);
            dfs(m - 1, j, board);
        }
        // Convert remaining O's to X and safe cells back to O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } 
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}