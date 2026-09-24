class Solution {
    public int helper(int idx, int[] nums, HashMap<Integer, Integer> mp, int k) {
        // Reached the end
        if (idx >= nums.length) {
            return 1;
        }
        int result = 0;
        // NOT TAKE
        result += helper(idx + 1, nums, mp, k);
        // TAKE
        if (!mp.containsKey(nums[idx] - k) && !mp.containsKey(nums[idx] + k)) {
            // DO
            mp.put(nums[idx], mp.getOrDefault(nums[idx], 0) + 1);
            // EXPLORE
            result += helper(idx + 1, nums, mp, k);
            // UNDO
            mp.put(nums[idx], mp.get(nums[idx]) - 1);
            // Remove it if frequency becomes 0
            if (mp.get(nums[idx]) == 0) {
                mp.remove(nums[idx]);
            }
        }
        return result;
    }

    public int beautifulSubsets(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        // Subtract 1 because empty subset is not beautiful
        return helper(0, nums, mp, k) - 1;
    }
}