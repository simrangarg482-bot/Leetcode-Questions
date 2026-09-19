class Solution {
    public boolean checkOverlap(int r, int xc , int yc , int x1, int y1, int x2, int y2) {
        // nearest point 
        int xi;
        int yi;

        if(x1 > xc) {
            xi = x1;
        } else if(x2 < xc) {
            xi = x2;
        } else {
            xi = xc;
        }

        if(y1 > yc) {
            yi = y1;
        } else if(y2 < yc) {
            yi = y2;
        } else {
            yi = yc;
        }

        // (distance btw (xi, yi) and (xc, yc)) 
        return Math.sqrt((xi-xc)*(xi-xc) + (yi-yc)*(yi-yc)) <= r;
    }
}