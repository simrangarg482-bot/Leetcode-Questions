class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;
        // Calculate free copies for each item
        int[] copies = new int[n];
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (items[j][0] % items[i][0] == 0) {
                    copies[i]++;
                }
            }
        }
        // Apply 0/1 Knapsack
        int[] dp = new int[budget + 1];
        for (int i = 0; i < n; i++) {
            int weight = items[i][1];       // Price
            int value = 1 + copies[i];      // Purchased + free items
            for (int b = budget; b >= weight; b--) {
                int dontBuy = dp[b];
                int buy = dp[b - weight] + value;
                dp[b] = Math.max(dontBuy, buy);
            }
        }
        // Spend remaining budget on cheapest item
        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            int remaining = budget - b;
            int totalItems = dp[b] + remaining / minPrice;
            ans = Math.max(ans, totalItems);
        }
        return ans;
    }
}