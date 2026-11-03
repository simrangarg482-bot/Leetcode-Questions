class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int requiredDays = 1;
            int currentLoad = 0;
            for (int weight : weights) {
                if (currentLoad + weight > mid) {
                    requiredDays++;
                    currentLoad = weight;
                } 
                else {
                    currentLoad += weight;
                }
            }
            if (requiredDays <= days) {
                ans = mid;
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}