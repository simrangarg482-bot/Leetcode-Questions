class Solution {
    public int ladderLength(String begin, String end, List<String> word) {
        HashSet<String> set = new HashSet<>();
        HashSet<Character> options = new HashSet<>();
        for (int i = 0; i < word.size(); i++) {
            set.add(word.get(i));
            for (int j = 0; j < word.get(i).length(); j++) {
                options.add(word.get(i).charAt(j));
            }
        }
        if (!set.contains(end)) {
            return 0;
        }
        int count = 1;
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String front = q.poll();
                if (front.equals(end)) {
                    return count;
                }
                char[] arr = front.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];
                    for (char ele : options) {
                        arr[i] = ele;
                        String neww = new String(arr);
                        if (set.contains(neww)) {
                            q.add(neww);
                            set.remove(neww); // this is just a shortcut, you can also use a visited hashset just  like you used in the ques 'open the lock'
                        }
                    }
                    arr[i] = original;
                }
            }
            count++;
        }
        return 0;
    }
}