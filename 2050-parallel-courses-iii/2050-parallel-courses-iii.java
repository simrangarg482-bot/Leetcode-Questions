class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int ans = Integer.MIN_VALUE;
        int [] max = new int[n];
        for(int i=0; i<n; i++) {
            max[i] = time[i];
        }
        int len = relations.length; 
        int [] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<len; i++) {
            int a = relations[i][0];
            int b = relations[i][1];
            adj.get(a-1).add(b-1);
            indegree[b-1]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        while(q.size() > 0) {
            int front = q.poll();
            for(int ele: adj.get(front)) {
                max[ele] = Math.max(max[ele], max[front] + time[ele]);
                indegree[ele]--;
                if(indegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }
        for(int ele: max) {
            if(ans < ele) {
                ans = ele;
            }
        }
        return ans;
    }
}