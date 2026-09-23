class Solution {
    public boolean helper(int i, int n, int[] result, boolean[] used) {

        if (i >= result.length) {
            return true;
        }

        if (result[i] != -1) {
            return helper(i + 1, n, result, used);
        }

        // Try larger numbers first
        for (int num = n; num >= 1; num--) {

            if (used[num]) continue;

            // Number 1 appears only once
            if (num == 1) {

                result[i] = 1;
                used[1] = true;

                if (helper(i + 1, n, result, used)) {
                    return true;
                }

                // Undo
                result[i] = -1;
                used[1] = false;

            } else {

                int j = i + num;

                // Both positions must be inside the array
                // and the second position must be empty
                if (j < result.length && result[j] == -1) {

                    result[i] = num;
                    result[j] = num;
                    used[num] = true;

                    if (helper(i + 1, n, result, used)) {
                        return true;
                    }

                    // Undo
                    result[i] = -1;
                    result[j] = -1;
                    used[num] = false;
                }
            }
        }

        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2*n-1];
        boolean[] used = new boolean[n + 1];
        Arrays.fill(result, -1);
        helper(0, n, result, used);
        return result;
    }
}