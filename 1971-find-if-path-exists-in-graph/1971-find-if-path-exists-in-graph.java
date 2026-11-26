class Solution {
    private void bfs(int source, List<List<Integer>> adj, boolean [] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while(!q.isEmpty()) {
            int front = q.remove();
            for(int ele: adj.get(front)) {
                if(!visited[ele]) {
                    q.add(ele);
                    visited[ele] = true;
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean [] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int [] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        bfs(source, adj, visited);
        return visited[destination];
    }
}