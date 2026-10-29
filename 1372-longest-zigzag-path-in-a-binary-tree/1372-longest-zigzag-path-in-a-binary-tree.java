class Solution {
    private void dfs(TreeNode node, int left, int right) {
        if (node == null) {
            return;
        }
        max = Math.max(max, Math.max(left, right));
        dfs(node.left, right + 1, 0);
        dfs(node.right, 0, left + 1);
    }
    int max = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0);
        return max;
    }
}