class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        if(curr == null || curr.next == null || curr.next.next == null) return new int []{-1,-1};
        List<Integer> arr = new ArrayList<>();
        int idx = 1;
        if(curr.next != null) {
            next = curr.next;
        }
        while(next != null && next.next != null) {
            prev = curr;
            curr = next;
            next = next.next;
            idx++;
            if(curr.val < prev.val && curr.val < next.val) {
                arr.add(idx);
            }
            if(curr.val > prev.val && curr.val > next.val) {
                arr.add(idx);
            }
        }
        if(arr.size() < 2) return new int []{-1,-1};
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            min = Math.min(min, arr.get(i) - arr.get(i - 1));
        }
        int max = arr.get(arr.size() - 1) - arr.get(0);
        return new int[]{min, max};
    }
}