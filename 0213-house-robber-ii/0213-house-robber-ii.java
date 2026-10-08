class Solution {
    public int helper(int st, int en, int [] nums, int [] dp) {
        if(st > en) {
            return 0;
        }
        if(dp[st] != -1) return dp[st];
        int take = nums[st] + helper(st+2, en, nums, dp);
        int not_take = helper(st+1, en, nums, dp);
        return dp[st] = Math.max(take, not_take);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(helper(0, n-2, nums, dp1), helper(1, n-1, nums, dp2));
    }
}