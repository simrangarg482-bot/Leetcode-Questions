class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String target = "123450";
        int[][] moves = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                String current = q.poll();
                if (current.equals(target)) {
                    return steps;
                }
                int zero = current.indexOf('0');
                for (int next : moves[zero]) {
                    char[] arr = current.toCharArray();
                    char temp = arr[zero];
                    arr[zero] = arr[next];
                    arr[next] = temp;
                    String newState = new String(arr);
                    if (!visited.contains(newState)) {
                        visited.add(newState);
                        q.add(newState);
                    }
                }
                size--;
            }
            steps++;
        }
        return -1;
    }
}