class Solution {
    public List<Integer> inorder(TreeNode root, List<Integer> list) {
        if(root == null) return list;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        List<Integer> ans = new ArrayList<>();
        ans = inorder(root, ans);
        return ans.get(k-1);
    }
}