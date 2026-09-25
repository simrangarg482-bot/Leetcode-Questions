class Solution {

    public int helper(int idx, int[] cookies, List<Integer> children, int k) {

        // All cookies have been distributed
        if (idx == cookies.length) {

            int unfairness = 0;

            // Find the child with maximum cookies
            for (int cookiesGiven : children) {
                unfairness = Math.max(unfairness, cookiesGiven);
            }

            return unfairness;
        }

        int cookie = cookies[idx];
        int result = Integer.MAX_VALUE;

        // Give current cookie to each child
        for (int i = 0; i < k; i++) {

            // Give cookie to child i
            children.set(i, children.get(i) + cookie);

            // Recursively distribute remaining cookies
            int unfairness = helper(idx + 1, cookies, children, k);

            // Keep the minimum unfairness
            result = Math.min(result, unfairness);

            // Backtrack
            children.set(i, children.get(i) - cookie);
        }

        return result;
    }

    public int distributeCookies(int[] cookies, int k) {

        // Initially every child has 0 cookies
        List<Integer> children = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            children.add(0);
        }

        return helper(0, cookies, children, k);
    }
}