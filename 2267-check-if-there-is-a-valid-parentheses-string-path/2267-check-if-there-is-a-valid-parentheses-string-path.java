class Solution {
    int m, n;
    char[][] grid;
    Boolean[][][] dp;
    public boolean dfs(int r, int c, int balance) {
        // Take the current cell
        if (grid[r][c] == '(') balance++;
        else balance--;
        // Invalid path
        if (balance < 0) return false;
        // Destination
        if (r == m - 1 && c == n - 1) return balance == 0;
        // Number of cells still available after current cell
        int remaining = (m - r - 1) + (n - c - 1);
        // Even if all remaining cells are ')',
        // we cannot bring balance down to zero
        if (balance > remaining) return false;
        if (dp[r][c][balance] != null) return dp[r][c][balance];
        boolean result = false;
        if (r + 1 < m) result = dfs(r + 1, c, balance);
        if (!result && c + 1 < n) result = dfs(r, c + 1, balance);
        dp[r][c][balance] = result;
        return result;
    }
    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        if (grid[0][0] != '(' || grid[m - 1][n - 1] != ')') return false;
        if ((m + n - 1) % 2 != 0) return false;
        dp = new Boolean[m][n][m + n];
        return dfs(0, 0, 0);
    }
}