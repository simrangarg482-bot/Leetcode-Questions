class DisjointSet {
    int[] parent;
    int[] rank;
    int[] size;
    int components;
    DisjointSet(int nodes) {
        this.parent = new int[nodes];
        this.rank = new int[nodes];
        this.size = new int[nodes];

        // Initially every node is a separate component
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

        // Already in the same component
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
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if(edges < n-1) return -1;
        int wires = 0;
        DisjointSet dsu = new DisjointSet(n);
        for(int [] connection: connections) {
            int u = connection[0];
            int v = connection[1];
            if(dsu.unionBySize(u, v)) wires++;
        }
        return n-1-wires;
    }
}