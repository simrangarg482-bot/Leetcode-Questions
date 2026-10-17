class Solution {
    public int solve(int[] nums, int[][] dp, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }
        if (dp[left][right] != -1) return dp[left][right];
        int max = 0;
        for (int i = left + 1; i < right; i++) {
            int coins = nums[left] * nums[i] * nums[right];
            int remaining = solve(nums, dp, left, i) + solve(nums, dp, i, right);
            max = Math.max(max, coins + remaining);
        }
        dp[left][right] = max;
        return max;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(arr, dp, 0, n + 1);
    }
}