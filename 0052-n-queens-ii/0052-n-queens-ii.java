class Solution {
    public int nqueen(char [][] board,int row, int count) {
        int n = board.length;
        if(row == n) {
            return count+1;
        }
        for(int i=0; i<n; i++) {
            if(isSafe(board, row, i)) {
                board[row][i] = 'Q';
                count = nqueen(board, row + 1, count);
                board[row][i] = '.';
            }
        }
        return count;
    }
    public boolean isSafe(char [][] board, int row, int col) {
        int n = board.length;
        for(int i=0; i<n; i++) {
            if(board[i][col] == 'Q') return false;
        }
        int i = row;
        int j = col;
        while(i >=0 && j>=0) {
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        i = row;
        j = col;
        while(i >=0 && j<n) {
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        i = row;
        j = col;
        while(i <n && j>=0) {
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }
        i = row;
        j = col;
        while(i<n && j<n) {
            if(board[i][j] == 'Q') return false;
            i++;
            j++;
        }
        return true;
    }
    public int totalNQueens(int n) {
        int count = 1;
        char [][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        return nqueen(board, 0, 0);
    }
}