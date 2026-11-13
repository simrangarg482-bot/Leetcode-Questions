// dijikstra's algo
class Pair {
        int node;
        long dist;
        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        int MOD = 1_000_000_007;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            long d = current.dist;
            if (d > dist[u]) continue;
            for (Pair next : adj.get(u)) {
                int v = next.node;
                long wt = next.dist;
                long newDist = d + wt;
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.add(new Pair(v, newDist));
                }
                // Found another shortest path
                else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return (int) ways[n - 1];
    }
}