class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'A') {
                absent++;
            } else if(s.charAt(i) == 'L') {
                late++;
                if(i+2 < s.length() && s.charAt(i+1) == 'L' && s.charAt(i+2) == 'L') {
                    late+=2; 
                    return false;
                }
            }
        }
        if(absent >= 2) return false;
        return true;
    }
}