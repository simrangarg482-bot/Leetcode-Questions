class Solution {

    public int helper(int i, int[] score, String[] words, int currScore, int[] freq) {

        int maxScore = Integer.MIN_VALUE;

        if (i >= words.length) return currScore;

        int j = 0;
        int[] tempFreq = freq.clone();
        int tempScore = 0;

        while (j < words[i].length()) {

            char ch = words[i].charAt(j);

            tempFreq[ch - 'a']--;
            tempScore += score[ch - 'a'];

            if (tempFreq[ch - 'a'] < 0) {
                break;
            }

            j++;
        }

        // Take the current word
        if (j == words[i].length()) {
            maxScore = Math.max(maxScore, helper(i + 1, score, words, currScore + tempScore, tempFreq));
        }

        // Don't take the current word
        maxScore = Math.max(maxScore, helper(i + 1, score, words, currScore, freq));

        return maxScore;
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        int[] freq = new int[26];

        for (char ch : letters) {
            freq[ch - 'a']++;
        }

        return helper(0, score, words, 0, freq);
    }
}