class Solution {
    public int convert(String date, int[] days) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));

        return days[month - 1] + day;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(1, 31);
        mp.put(2, 28);
        mp.put(3, 31);
        mp.put(4, 30);
        mp.put(5, 31);
        mp.put(6, 30);
        mp.put(7, 31);
        mp.put(8, 31);
        mp.put(9, 30);
        mp.put(10, 31);
        mp.put(11, 30);
        mp.put(12, 31);
        int[] days = new int[13];
        for (int i = 1; i <= 12; i++) {
            days[i] = days[i - 1] + mp.get(i);
        }
        int a1 = convert(arriveAlice, days);
        int a2 = convert(leaveAlice, days);
        int b1 = convert(arriveBob, days);
        int b2 = convert(leaveBob, days);
        int start = Math.max(a1, b1);
        int end = Math.min(a2, b2);
        return Math.max(0, end - start + 1);
    }
}
