class Solution {
    int target;
    public boolean backtrack(int[] matchsticks, int index, int[] sides) {
        if (index < 0) {
            return true;
        }
        int stick = matchsticks[index];
        for (int i = 0; i < 4; i++) {
            if (sides[i] + stick > target) {
                continue;
            }
            sides[i] += stick;
            if (backtrack(matchsticks, index - 1, sides)) {
                return true;
            }
            sides[i] -= stick;
            // Avoid equivalent empty-side choices
            // if (sides[i] == 0) {
            //     break;
            // }
        }
        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for (int stick : matchsticks) {
            total += stick;
        }
        if (total % 4 != 0) {
            return false;
        }
        target = total / 4;
        Arrays.sort(matchsticks);
        int[] sides = new int[4];
        return backtrack(matchsticks, matchsticks.length - 1, sides);
    }
}