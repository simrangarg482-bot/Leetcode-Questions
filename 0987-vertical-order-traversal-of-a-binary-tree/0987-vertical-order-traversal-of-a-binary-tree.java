class Solution {
    // Stores: {column, row, value}
    List<int[]> nodes = new ArrayList<>();
    private void dfs(TreeNode root, int row, int col) {
        if (root == null) return;
        nodes.add(new int[]{col, row, root.val});
        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, 0);
        // Sort by column, then row, then value
        Collections.sort(nodes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        int prevCol = Integer.MIN_VALUE;
        for (int[] node : nodes) {
            int col = node[0];
            int val = node[2];
            if (col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = col;
            }
            result.get(result.size() - 1).add(val);
        }
        return result;
    }
}
