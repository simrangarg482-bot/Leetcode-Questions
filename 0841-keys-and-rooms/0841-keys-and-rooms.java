class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] visited = new boolean[rooms.size()];
        visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(q.size() > 0) {
            int front = q.poll();
            for(int ele: rooms.get(front)) {
                if(!visited[ele]) {
                    visited[ele] = true;
                    q.add(ele);
                }
            }
        }
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) return false;
        }
        return true;
    }
}