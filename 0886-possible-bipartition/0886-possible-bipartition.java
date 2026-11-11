class Solution {
    public void helper(int i, List<List<Integer>> adj, int[] colours) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        colours[i] = 1;
        while(!q.isEmpty()) {
            int front = q.poll();
            int curr_col = colours[front];
            for(int edge : adj.get(front)) {
                if(colours[edge] == curr_col) {
                    ans = false;
                    return;
                }
                else if(colours[edge] == -1) {
                    colours[edge] = 1 - curr_col;
                    q.add(edge);
                }
            }
        }
    }
    static boolean ans;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : dislikes) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] colours = new int[n];
        Arrays.fill(colours, -1);
        ans = true;
        for(int i = 0; i < n; i++) {
            if(colours[i] == -1) {
                helper(i, adj, colours);
                if(!ans) return false;
            }
        }
        return true;
    }
}