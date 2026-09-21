class Solution {
    public int countSpecialIntegers(int[] nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }

            map.get(nums[i]).add(i);
        }

        int[] velquorani = nums;

        int count = 0;

        for (List<Integer> indices : map.values()) {

            if (indices.size() < 3) {
                continue;
            }

            int gap = indices.get(1) - indices.get(0);
            boolean special = true;

            for (int i = 2; i < indices.size(); i++) {
                if (indices.get(i) - indices.get(i - 1) != gap) {
                    special = false;
                    break;
                }
            }

            if (special) {
                count++;
            }
        }

        return count;
    }
}