class Solution {
    public boolean subset(int i, int [] arr, int target, int [][] dp) {
        if(i == arr.length) {
            if(target == 0) return true;
            return false;
        }
        if(dp[i][target] != -1) {
            if(dp[i][target] == 1) return true;
            return false;
        }
        boolean skip = subset(i+1, arr, target, dp);
        boolean ans = false;
        if(target - arr[i] < 0) {
            // valid only for +ve numbers 
            ans = skip;
        } else {
            boolean pick = subset(i+1, arr, target - arr[i], dp);
            ans = pick || skip;
        }
        if(ans == true) dp[i][target] = 1;
        else dp[i][target] = 0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele: nums) sum += ele;
        if(sum % 2 != 0) return false;
        int target = sum/2;
        int n = nums.length;
        int [][] dp = new int[n][target+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return subset(0, nums, target, dp);
    }
}