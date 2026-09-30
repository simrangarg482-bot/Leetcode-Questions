class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int depth = 0;
        int [] result = new int[seq.length()];
        for(int i=0; i<seq.length(); i++) {
            if(seq.charAt(i) == '(') {
                depth++;
                result[i] = (depth%2 == 0)?0:1;
            } else {
                result[i] = (depth%2 == 0)?0:1;
                depth--;
            }
        }
        return result;
    }
}