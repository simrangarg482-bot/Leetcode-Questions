class Solution {
    public List<Integer> helper(TreeNode root, List<Integer> result) {
        if(root == null) return result;
        helper(root.left, result);
        helper(root.right, result);
        result.add(root.val);
        return result;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return helper(root, result);
    }
}