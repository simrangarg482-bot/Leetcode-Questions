class Solution {
    public void helper(int i, String currSentence, String s, List<String> result, HashSet<String> set) {
        if(i >= s.length()) {
            result.add(currSentence);
            return;
        }
        for(int j=i; j<s.length(); j++) {
            String tempWord = s.substring(i, j+1);
            if(set.contains(tempWord)) {
                String tempSentence = currSentence;
                if(!currSentence.isEmpty()) {
                    currSentence += " ";
                }
                currSentence += tempWord;
                helper(j+1, currSentence, s, result, set);
                currSentence = tempSentence;
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        String currSentence = "";
        HashSet<String> set = new HashSet<>();
        for(String str: wordDict) {
            set.add(str);
        }
        List<String> result = new ArrayList<>();
        helper(0, currSentence, s, result, set);
        return result;
    }
}