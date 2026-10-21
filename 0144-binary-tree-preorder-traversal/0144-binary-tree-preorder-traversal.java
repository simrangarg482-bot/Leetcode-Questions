class Solution {
    public List<Integer> helper(TreeNode root, List<Integer> result) {
        if(root == null) return result;
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
        return result;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return helper(root, result);
    }
}