class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        // Initialize graph
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        // Build graph
        for (int[] edge : richer) {
            int u = edge[0]; // richer person
            int v = edge[1]; // poorer person
            graph.get(u).add(v);
            indegree[v]++;
        }
        // Initialize answer
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = i;
        }
        // Step 4: Initialize queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        // Topological Sort
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                // Check who is quieter
                if (quiet[answer[current]] < quiet[answer[neighbor]]) {
                    answer[neighbor] = answer[current];
                }
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return answer;
    }
}