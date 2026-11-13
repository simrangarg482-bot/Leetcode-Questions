class Solution {

    public int findTheCity(int n, int[][] edges, int threshold) {

        int[][] dist = new int[n][n];

        // Initialize
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        // Add edges
        for(int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            dist[u][v] = Math.min(dist[u][v], wt);
            dist[v][u] = Math.min(dist[v][u], wt);
        }

        // Floyd-Warshall
        for(int k = 0; k < n; k++) {

            for(int i = 0; i < n; i++) {

                for(int j = 0; j < n; j++) {

                    if(dist[i][k] != Integer.MAX_VALUE &&
                       dist[k][j] != Integer.MAX_VALUE) {

                        dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                        );
                    }
                }
            }
        }

        // Find city with minimum reachable cities
        int minCity = -1;
        int minCount = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {

            int count = 0;

            for(int j = 0; j < n; j++) {

                if(dist[i][j] <= threshold) {
                    count++;
                }
            }

            // <= is important because we want the larger
            // city number when counts are equal
            if(count <= minCount) {
                minCount = count;
                minCity = i;
            }
        }

        return minCity;
    }
}