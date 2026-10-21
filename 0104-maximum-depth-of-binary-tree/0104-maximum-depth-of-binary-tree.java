class Solution {
    public int helper(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        return 1 + Math.max(helper(root.left), helper(root.right));
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return helper(root) + 1;
    }
}