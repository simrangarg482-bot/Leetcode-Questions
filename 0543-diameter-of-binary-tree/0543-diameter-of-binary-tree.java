class Solution {
    public int height(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int left = (root.left != null)? 1 + height(root.left): 0;
        int right = (root.right != null)? 1 + height(root.right): 0;
        int dia = left + right;
        return Math.max(dia, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }
}