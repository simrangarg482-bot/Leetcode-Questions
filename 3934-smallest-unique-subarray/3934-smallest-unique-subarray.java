class Solution {
    private boolean check(int[] nums, int len) {
        int n = nums.length;
        long base = 1;
        for (int num : nums) {
            base = Math.max(base, num + 1L);
        }
        long hash = 0;
        long power = 1;
        // Calculate base^(len - 1)
        for (int i = 0; i < len - 1; i++) {
            power *= base;
        }
        Map<Long, Integer> freq = new HashMap<>();
        // Calculate hash of the first window
        for (int i = 0; i < len; i++) {
            hash = hash * base + nums[i];
        }
        freq.put(hash, 1);
        // Slide the window
        for (int i = len; i < n; i++) {
            hash = (hash - nums[i - len] * power) * base + nums[i];
            freq.put(hash, freq.getOrDefault(hash, 0) + 1);
        }
        // Check whether any subarray occurs exactly once
        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }
        return false;
    }
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int low = 1, high = n;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(nums, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }   
}