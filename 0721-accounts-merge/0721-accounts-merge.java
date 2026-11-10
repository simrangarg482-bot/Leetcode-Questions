class DisjointSet {
    int[] parent;
    int[] rank;
    int[] size;
    int components;

    DisjointSet(int nodes) {
        this.parent = new int[nodes];
        this.rank = new int[nodes];
        this.size = new int[nodes];

        this.components = nodes;

        for (int i = 0; i < nodes; i++) {
            this.parent[i] = i;
            this.rank[i] = 0;
            this.size[i] = 1;
        }
    }

    public int findRootParent(int node) {
        if (node == parent[node]) {
            return node;
        }

        // Path compression
        parent[node] = findRootParent(parent[node]);

        return parent[node];
    }

    public void UnionByRank(int node1, int node2) {

        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);

        if (rootParent1 == rootParent2) {
            return;
        }

        components--;

        if (rank[rootParent1] < rank[rootParent2]) {
            parent[rootParent1] = rootParent2;
        }
        else if (rank[rootParent1] > rank[rootParent2]) {
            parent[rootParent2] = rootParent1;
        }
        else {
            parent[rootParent2] = rootParent1;
            rank[rootParent1]++;
        }
    }

    public boolean unionBySize(int node1, int node2) {

        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);

        // Already connected -> cycle
        if (rootParent1 == rootParent2) {
            return false;
        }

        components--;

        if (size[rootParent1] < size[rootParent2]) {
            parent[rootParent1] = rootParent2;
            size[rootParent2] += size[rootParent1];
        }
        else {
            parent[rootParent2] = rootParent1;
            size[rootParent1] += size[rootParent2];
        }

        return true;
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> details) {

        int n = details.size();

        DisjointSet ds = new DisjointSet(n);

        // email -> account index
        HashMap<String, Integer> mp = new HashMap<>();

        // STEP 1: Union accounts having common emails
        for (int i = 0; i < n; i++) {

            for (int j = 1; j < details.get(i).size(); j++) {

                String mail = details.get(i).get(j);

                if (!mp.containsKey(mail)) {
                    mp.put(mail, i);
                }
                else {
                    ds.unionBySize(i, mp.get(mail));
                }
            }
        }

        // STEP 2: root -> list of emails
        ArrayList<String>[] merge = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            merge[i] = new ArrayList<>();
        }

        // Put every email into its account's root
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {

            String mail = entry.getKey();
            int account = entry.getValue();

            int root = ds.findRootParent(account);

            merge[root].add(mail);
        }

        // STEP 3: Build final answer
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (merge[i].isEmpty()) {
                continue;
            }

            Collections.sort(merge[i]);

            List<String> account = new ArrayList<>();

            // Account name
            account.add(details.get(i).get(0));

            // Sorted emails
            account.addAll(merge[i]);

            ans.add(account);
        }

        return ans;
    }
}
