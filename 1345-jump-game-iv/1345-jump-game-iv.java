class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        // value -> all indices having that value
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0] = true;
        int jumps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int i = q.poll();
                if (i == n - 1) {
                    return jumps;
                }
                // Move left
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.add(i - 1);
                }
                // Move right
                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.add(i + 1);
                }
                // Jump to all indices having same value
                if (map.containsKey(arr[i])) {
                    for (int next : map.get(arr[i])) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.add(next);
                        }
                    }
                    // Don't process these same-value indices again
                    map.get(arr[i]).clear();
                }
                size--;
            }
            jumps++;
        }
        return -1;
    }
}