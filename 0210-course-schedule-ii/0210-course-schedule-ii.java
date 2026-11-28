// topological sort 
class Solution {
    public int[] topologicalSort(Map<Integer, List<Integer>> adj, int[] indegree, int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] result = new int[n];
        int index = 0;
        while (!q.isEmpty()) {
            int top = q.remove();
            result[index++] = top;  
            if (adj.containsKey(top)) {
                for (int ele : adj.get(top)) {
                    indegree[ele]--;
                    if (indegree[ele] == 0) {
                        q.add(ele);
                    }
                }
            }
        }
        if (index == n) {
            return result; 
        }
        return new int[0];  //cycle exists
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] node : prerequisites) {
            int a = node[0];
            int b = node[1];
            indegree[a]++;
            if (!adj.containsKey(b)) {
                adj.put(b, new ArrayList<>());
            }
            adj.get(b).add(a);
        }
        return topologicalSort(adj, indegree, numCourses);
    }
}