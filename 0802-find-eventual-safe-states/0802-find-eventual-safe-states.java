// basically, jo nodes cycle form kr rahe h, vo terminal nodes nahi h and thereby not a safe node so we can find those nodes which are not forming cycle by topological sort but we cannot apply TS sirectly here 
// reverse the graph and then apply topological sort (TS) ---> ye hamne isliye kiya qki TS unn nodes ko ans me deta hai jinki indegree 0 ho, but hame vo nodes chahiye jinkin outdegree 0 ho not indegree
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // Step 1: create reversed graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i =0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        // Step 2: build reverse graph + indegree
        for (int i = 0; i < n; i++) {
            for (int ele : graph[i]) {
                // reverse edge: ele -> i
                adj.get(ele).add(i);
                indegree[i]++;
            }
        }
        // Step 3: Kahn's Algorithm (BFS)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.remove();
            result.add(node);  // safe node
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        // Step 4: sort result (important for this problem)
        Collections.sort(result);
        return result;
    }
}