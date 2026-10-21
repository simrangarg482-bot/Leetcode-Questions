class Solution {
    public boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false;
        return helper(root.left, root.right);
    }
}