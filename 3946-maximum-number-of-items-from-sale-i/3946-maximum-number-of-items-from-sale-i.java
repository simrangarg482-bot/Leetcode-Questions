class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;
        int[] copies = new int[n];
        // Calculate free copies for every item
        for(int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(items[j][0] % items[i][0] == 0) {
                    copies[i]++;
                }
            }
        }
        // 0/1 Knapsack 
        int[] dp = new int[budget + 1];
        for(int i = 0; i < n; i++) {
            int price = items[i][1];
            int gain = 1 + copies[i];
            for(int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + gain);
            }
        }
        // Spend remaining budget on cheapest item
        int ans = 0;
        for(int b = 0; b <= budget; b++) {
            int remaining = budget - b;
            ans = Math.max(ans, dp[b] + remaining / minPrice);
        }
        return ans;
    }
}