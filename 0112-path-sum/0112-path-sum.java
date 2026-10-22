class Solution {
    public boolean helper(TreeNode root, int target) {
        if(root == null) return false;
        if(target == root.val && root.left == null && root.right == null) return true;
        return helper(root.left, target - root.val) || helper(root.right, target - root.val);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum);
    }
}