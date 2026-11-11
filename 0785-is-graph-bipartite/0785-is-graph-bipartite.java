// intuiton--> any graph without cycle will always be bipartitle and any cycle with even no of nodes is always bipartitle, to check for bipartitle, colour all the nodes with 2 different colours such that no two nodes may have the same colour
class Solution {
    static boolean ans;
    public void bfs(int i, int[][] adj, int[] colour) {
        Queue<Integer> q = new LinkedList<>();       
        q.add(i);
        colour[i] = 1;  // 1 -> red, 0 -> blue
        while (!q.isEmpty()) {
            int front = q.remove();
            int curr_colour = colour[front];
            for (int ele : adj[front]) {
                if (colour[ele] == curr_colour) {
                    ans = false;
                    return;
                }
                if (colour[ele] == -1) {
                    colour[ele] = 1 - curr_colour;
                    q.add(ele);
                }
            }
        }
    }
    public boolean isBipartite(int[][] adj) {
        ans = true;
        int n = adj.length;
        int[] colour = new int[n];
        Arrays.fill(colour, -1);
        for (int i = 0; i < n; i++) {
            if (colour[i] == -1) {
                bfs(i, adj, colour);
                if (!ans) return false;
            }
        }
        return ans;
    }
}