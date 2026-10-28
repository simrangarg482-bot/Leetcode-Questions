class Solution {
    int ans = 0;
    private void dfs(TreeNode node, int min, int max) {
        if (node == null) {
            return;
        }
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);
        ans = Math.max(ans, max - min);
        dfs(node.left, min, max);
        dfs(node.right, min, max);
    }
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }
}