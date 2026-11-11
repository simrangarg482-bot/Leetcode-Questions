class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // Case 1 - Buy only Type 1 and Type 2 items
        long a = (long) need1 * cost1 + (long) need2 * cost2;
        // Case 2 - Buy only Type 3 items
        long b = (long) Math.max(need1, need2) * costBoth;
        // Case 3 - Buy Type 3 for common requirements, then buy separate items for remaining requirements
        int mn = Math.min(need1, need2);
        long c = (long) mn * costBoth + (long) (need1 - mn) * cost1 + (long) (need2 - mn) * cost2;
        return Math.min(a, Math.min(b, c));
    }
}