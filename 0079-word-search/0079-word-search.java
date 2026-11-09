class Solution {
    public boolean backtrack(char [][] board, String word, int idx, int i, int j, boolean [][] visited) {
        int m = board.length;
        int n = board[0].length;
        if(idx == word.length()) {
            return true;
        }
        char ch = word.charAt(idx);
        if(i - 1 >= 0 && !visited[i-1][j] && board[i-1][j] == ch) {
            visited[i-1][j] = true;
            if(backtrack(board, word, idx+1, i-1, j, visited)) {
                return true;
            }
            visited[i-1][j] = false;
        }
        if(j - 1 >= 0 && !visited[i][j-1] && board[i][j-1] == ch) {
            visited[i][j-1] = true;
            if(backtrack(board, word, idx+1, i, j-1, visited)) {
                return true;
            }
            visited[i][j-1] = false;
        }
        if(i + 1 < m && !visited[i+1][j] && board[i+1][j] == ch) {
            visited[i+1][j] = true;
            if(backtrack(board, word, idx+1, i+1, j, visited)) {
                return true;
            }
            visited[i+1][j] = false;
        }
        if(j + 1 < n && !visited[i][j+1] && board[i][j+1] == ch) {
            visited[i][j+1] = true;
            if(backtrack(board, word, idx+1, i, j+1, visited)) {
                return true;
            }
            visited[i][j+1] = false;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean [][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if(backtrack(board, word, 1, i, j, visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
}