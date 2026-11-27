class Solution {
    public void dfs(int row, int col, boolean [][] vis, char [][] board) {
        int m = board.length;
        int n = board[0].length;
        vis[row][col] = true;
        // up
        if(row - 1 >= 0 && board[row - 1][col] == 'O' && !vis[row - 1][col]) {
            dfs(row - 1, col, vis, board);
        }
        // right
        if(col + 1 < n && board[row][col + 1] == 'O' && !vis[row][col + 1]) {
            dfs(row, col + 1, vis, board);
        }
        // down
        if(row + 1 < m && board[row + 1][col] == 'O' && !vis[row + 1][col]) {
            dfs(row + 1, col, vis, board);
        }
        // left
        if(col - 1 >= 0 && board[row][col - 1] == 'O' && !vis[row][col - 1]) {
            dfs(row, col - 1, vis, board);
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean [][] vis = new boolean[m][n];
        // traverse first row and last row
        for(int i = 0; i < n; i++) {
            // first row
            if(!vis[0][i] && board[0][i] == 'O') {
                dfs(0, i, vis, board);
            }
            // last row
            if(!vis[m - 1][i] && board[m - 1][i] == 'O') {
                dfs(m - 1, i, vis, board);
            }
        }
        // traverse first column and last column
        for(int i = 0; i < m; i++) {
            // first column
            if(!vis[i][0] && board[i][0] == 'O') {
                dfs(i, 0, vis, board);
            }
            // last column
            if(!vis[i][n - 1] && board[i][n - 1] == 'O') {
                dfs(i, n - 1, vis, board);
            }
        }
        // convert surrounded O's to X
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}