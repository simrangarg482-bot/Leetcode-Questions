class Solution {
    public boolean canAliceWin(int n) {
        boolean aliceTurn = true;
        for (int i = 10; i >= 1; i--) {
            if (n < i) {
                return !aliceTurn;
            }
            n -= i;
            aliceTurn = !aliceTurn;
        }
        return !aliceTurn;
    }
}