class Solution {
    public List<Integer> topoSort(int n, List<List<Integer>> adj) {
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++) {
            for(int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            for(int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }
        if(result.size() != n) {
            return new ArrayList<>();
        }
        return result;
    }
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // Assign a separate group to every -1 item
        for(int i = 0; i < n; i++) {
            if(group[i] == -1) {
                group[i] = m;
                m++;
            }
        }
        // Step 2: Create item and group adjacency lists
        List<List<Integer>> itemAdj = new ArrayList<>();
        List<List<Integer>> groupAdj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            itemAdj.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            groupAdj.add(new ArrayList<>());
        }
        // Step 3: Build both graphs
        for(int i = 0; i < n; i++) {
            for(int prev : beforeItems.get(i)) {
                // Item dependency: prev must come before i
                itemAdj.get(prev).add(i);
                // Group dependency: add only if groups are different
                if(group[prev] != group[i]) {
                    groupAdj.get(group[prev]).add(group[i]);
                }
            }
        }
        // Topological sort both graphs
        List<Integer> itemOrder = topoSort(n, itemAdj);
        List<Integer> groupOrder = topoSort(m, groupAdj);
        // If either graph contains a cycle
        if(itemOrder.size() != n || groupOrder.size() != m) {
            return new int[0];
        }
        // Store items according to their groups
        List<List<Integer>> groupedItems = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            groupedItems.add(new ArrayList<>());
        }
        for(int item : itemOrder) {
            groupedItems.get(group[item]).add(item);
        }
        // Build final answer using group order
        List<Integer> result = new ArrayList<>();
        for(int g : groupOrder) {
            for(int item : groupedItems.get(g)) {
                result.add(item);
            }
        }
        // Convert List<Integer> to int[]
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
