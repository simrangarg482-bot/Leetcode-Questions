class Solution {

    public int helper(String s, int i, HashSet<String> set, int currCount) {

        if(i >= s.length()) {
            return currCount;
        }

        int maxCount = 0;

        for(int j = i; j < s.length(); j++) {

            String sub = s.substring(i, j + 1);

            if(!set.contains(sub)) {

                set.add(sub);

                int result = helper(s, j + 1, set, currCount + 1);

                maxCount = Math.max(maxCount, result);

                set.remove(sub);
            }
        }

        return maxCount;
    }

    public int maxUniqueSplit(String s) {

        HashSet<String> set = new HashSet<>();

        return helper(s, 0, set, 0);
    }
}