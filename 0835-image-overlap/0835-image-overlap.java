class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        Map<String, Integer> map = new HashMap<>();
        int maxOverlap = 0;
        for (int r1 = 0; r1 < n; r1++) {
            for (int c1 = 0; c1 < n; c1++) {
                // We only care about 1s in img1
                if (img1[r1][c1] == 0) {
                    continue;
                }
                for (int r2 = 0; r2 < n; r2++) {
                    for (int c2 = 0; c2 < n; c2++) {       
                        // We only care about 1s in img2
                        if (img2[r2][c2] == 0) {
                            continue;
                        }
                        int rowShift = r2 - r1;
                        int colShift = c2 - c1;
                        String shift = rowShift + "," + colShift;
                        map.put(shift, map.getOrDefault(shift, 0) + 1);
                        maxOverlap = Math.max(maxOverlap, map.get(shift));
                    }
                }
            }
        }
        return maxOverlap;
    }
}