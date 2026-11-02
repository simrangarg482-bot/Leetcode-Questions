class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int res = 0;
        int first = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int diff = intervals[i][0] - first;
            if (diff < 0) {
                res++;
                first = Math.min(first, intervals[i][1]);
            } else {
                first = intervals[i][1];
            }
        }
        return res;
    }
}