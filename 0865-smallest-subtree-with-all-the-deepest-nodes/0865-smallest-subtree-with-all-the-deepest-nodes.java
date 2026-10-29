class Result {
        int depth;
        TreeNode node;
        Result(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }
class Solution {
    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(0, null);
        }
        Result left = dfs(root.left);
        Result right = dfs(root.right);
        if (left.depth > right.depth) {
            return new Result(left.depth + 1, left.node);
        }
        if (right.depth > left.depth) {
            return new Result(right.depth + 1, right.node);
        }
        return new Result(left.depth + 1, root);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
}
