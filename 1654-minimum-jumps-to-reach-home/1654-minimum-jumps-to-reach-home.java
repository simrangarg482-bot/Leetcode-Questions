class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int limit = 6000;
        boolean[] blocked = new boolean[limit + 1];
        for (int pos : forbidden) {
            blocked[pos] = true;
        }
        // {position, last jump was backward?}
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        boolean[][] visited = new boolean[limit + 1][2];
        visited[0][0] = true;
        int jumps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] current = q.poll();
                int position = current[0];
                int lastBack = current[1];
                // Reached home
                if (position == x) {
                    return jumps;
                }
                // Forward jump
                int forward = position + a;
                if (forward <= limit && !blocked[forward] && !visited[forward][0]) {
                    visited[forward][0] = true;
                    q.add(new int[]{forward, 0});
                }
                // BACKWARD JUMP
                int backward = position - b;
                if (lastBack == 0 && backward >= 0 && !blocked[backward] && !visited[backward][1]) {
                    visited[backward][1] = true;
                    q.add(new int[]{backward, 1});
                }
            }
            jumps++;
        }
        return -1;
    }
}