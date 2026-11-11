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
    public int removeStones(int[][] stones) {

        int maxRow = 0;
        int maxCol = 0;

        // Find maximum row and column
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        // Total nodes = all rows + all columns
        int totalNodes = maxRow + maxCol + 2;

        DisjointSet dsu = new DisjointSet(totalNodes);

        HashMap<Integer, Integer> stoneNodes = new HashMap<>();

        for (int[] stone : stones) {

            int row = stone[0];

            // Shift column nodes so they don't clash with row nodes
            int col = maxRow + 1 + stone[1];

            dsu.unionBySize(row, col);

            // Store the nodes that actually occur
            stoneNodes.put(row, 1);
            stoneNodes.put(col, 1);
        }

        int components = 0;

        // Count roots among used nodes
        for (int node : stoneNodes.keySet()) {
            if (dsu.findRootParent(node) == node) {
                components++;
            }
        }

        return stones.length - components;
    }
}