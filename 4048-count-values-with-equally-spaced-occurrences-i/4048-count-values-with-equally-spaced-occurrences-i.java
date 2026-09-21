class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }

            map.get(nums[i]).add(i);
        }

        int count = 0;

        for (List<Integer> indices : map.values()) {
            if (indices.size() == 3) {
                int i1 = indices.get(0);
                int i2 = indices.get(1);
                int i3 = indices.get(2);

                if (i2 - i1 == i3 - i2) {
                    count++;
                }
            }
        }

        return count;
    }
}