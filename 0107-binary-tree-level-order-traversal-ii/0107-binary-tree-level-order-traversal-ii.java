class Solution {
     public int height(TreeNode root) {
            if(root == null || (root.left == null && root.right == null)) return 0;
                return 1 + Math.max(height(root.left), height(root.right));
        }
        public List<Integer> nth(TreeNode root, int n, List<Integer> arr) {
            if(root == null) return arr;
            if(n == 1) arr.add(root.val);
            nth(root.left, n-1, arr);
            nth(root.right, n-1, arr);
            return arr;
        }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root==null) return ans;
            int level = height(root) + 1;
            for(int i=level; i>=1; i--) {
               List<Integer> arr = new ArrayList<>();
               nth(root, i, arr); 
               ans.add(arr);
            }
            return ans;
    }
}