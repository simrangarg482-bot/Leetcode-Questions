class Solution {
    class Pair {
        int effort;
        int row;
        int col;

        Pair(int effort, int row, int col) {
            this.effort = effort;
            this.row = row;
            this.col = col;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }

        // Min Heap based on effort
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.effort, b.effort)
        );

        // Directions
        int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};

        pq.add(new Pair(0, 0, 0));
        ans[0][0] = 0;

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();

            int effort = curr.effort;
            int x = curr.row;
            int y = curr.col;

            // Reached destination
            if(x == m - 1 && y == n - 1) {
                return effort;
            }

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n) {

                    int newEffort = Math.max(
                        effort,
                        Math.abs(heights[x][y] - heights[nx][ny])
                    );

                    if(newEffort < ans[nx][ny]) {
                        ans[nx][ny] = newEffort;
                        pq.add(new Pair(newEffort, nx, ny));
                    }
                }
            }
        }
        return 0;
    }
}