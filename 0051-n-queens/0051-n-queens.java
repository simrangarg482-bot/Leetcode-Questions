class Solution {
    public void nqueen(char [][] board, int row, List<List<String>> result) {
        int n = board.length;
        if(row == n) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ans.add(new String(board[i]));
            }
            result.add(ans);
            return;
        }
        for(int j=0; j<n; j++) {
            if(isSafe(board, row, j)) {
            board[row][j] = 'Q';
            nqueen(board, row + 1, result);
            board[row][j] = '.';
        }
        }
    } 
    public boolean isSafe(char [][] board, int row, int col) {
        int n = board.length;
        for(int j=0; j<n; j++) {
            if(board[j][col] == 'Q') return false;
        }
        int i = row;
        int j = col;
        while(i>=0 && j<n) {
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        i = row;
        j = col;
        while(i<n && j<n) {
            if(board[i][j] == 'Q') return false;
            i++;
            j++;
        }
        i = row;
        j = col;
        while(i<n && j>=0) {
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }
        i = row;
        j = col;
        while(i>=0 && j>=0) {
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        char [][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        nqueen(board, 0, result);
        return result;
    }
}