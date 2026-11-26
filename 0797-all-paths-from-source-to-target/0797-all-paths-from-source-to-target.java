class Solution {
    public void dfs(int node, int[][] graph, List<Integer> path, List<List<Integer>> ans) {
        path.add(node);
        // Destination reached
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        // Explore all neighbours
        for (int neighbour : graph[node]) {
            dfs(neighbour, graph, path, ans);
        }
        // Backtracking
        path.remove(path.size() - 1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, graph, path, ans);
        return ans;
    }
}