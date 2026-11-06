class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        int m = queries.length;
        // Store query and its original index
        int[][] q = new int[m][2];
        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[m];
        int left = 0;
        int right = 0;
        for (int i = 0; i < m; i++) {
            int start = q[i][0] - x;
            int end = q[i][0];
            int index = q[i][1];
            // Add logs entering the window
            while (right < logs.length && logs[right][1] <= end) {
                int server = logs[right][0];
                map.put(server, map.getOrDefault(server, 0) + 1);
                right++;
            }
            // Remove logs leaving the window
            while (left < right && logs[left][1] < start) {
                int server = logs[left][0];
                map.put(server, map.get(server) - 1);
                if (map.get(server) == 0) {
                    map.remove(server);
                }
                left++;
            }
            ans[index] = n - map.size();
        }
        return ans;
    }
}