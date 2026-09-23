class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        List<int[]> litter = new ArrayList<>();
        int si = 0, sj = 0;
        // Find starting position and all litter positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'S') {
                    si = i;
                    sj = j;
                }
                if (classroom[i].charAt(j) == 'L') {
                    litter.add(new int[]{i, j});
                }
            }
        }
        int totalLitter = litter.size();
        if (totalLitter == 0) {
            return 0;
        }
        // state = row, col, energy, mask
        Queue<int[]> q = new LinkedList<>();
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << totalLitter];

        q.offer(new int[]{si, sj, energy, 0});
        visited[si][sj][energy][0] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] curr = q.poll();

                int i = curr[0];
                int j = curr[1];
                int e = curr[2];
                int mask = curr[3];

                // Collected everything
                if (mask == (1 << totalLitter) - 1) {
                    return moves;
                }

                // Cannot move anymore
                if (e == 0) {
                    continue;
                }

                for (int[] dir : directions) {

                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    // Outside grid
                    if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                        continue;
                    }

                    // Wall
                    if (classroom[ni].charAt(nj) == 'X') {
                        continue;
                    }

                    int newEnergy = e - 1;

                    // Recharge
                    if (classroom[ni].charAt(nj) == 'R') {
                        newEnergy = energy;
                    }

                    int newMask = mask;

                    // Check whether this cell contains litter
                    for (int k = 0; k < totalLitter; k++) {

                        if (litter.get(k)[0] == ni && litter.get(k)[1] == nj) {

                            newMask |= (1 << k);
                            break;
                        }
                    }

                    if (!visited[ni][nj][newEnergy][newMask]) {

                        visited[ni][nj][newEnergy][newMask] = true;

                        q.offer(new int[]{ni, nj, newEnergy, newMask});
                    }
                }
            }

            moves++;
        }
        return -1;
    }
}