class Solution {
    public boolean helper(int i, int r, int c, char[][] board, String word, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        if(r >= m || c >= n || r < 0 || c < 0 || visited[r][c] || board[r][c] != word.charAt(i)) {
            return false;
        }
        if(i == word.length() - 1) {
            return true;
        }
        visited[r][c] = true;
        if(helper(i + 1, r + 1, c, board, word, visited)) return true;
        if(helper(i + 1, r, c + 1, board, word, visited)) return true;
        if(helper(i + 1, r - 1, c, board, word, visited)) return true;
        if(helper(i + 1, r, c - 1, board, word, visited)) return true;
        visited[r][c] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(helper(0, i, j, board, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}