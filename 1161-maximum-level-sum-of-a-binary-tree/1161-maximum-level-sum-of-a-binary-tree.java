class Pair {
    TreeNode root;
    int level;
    Pair(TreeNode root, int level) {
        this.root = root;
        this.level = level;
    }
}
class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        int max = Integer.MIN_VALUE;
        int ans = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            int level = q.peek().level;
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                sum += p.root.val;
                if (p.root.left != null)
                    q.add(new Pair(p.root.left, p.level + 1));
                if (p.root.right != null)
                    q.add(new Pair(p.root.right, p.level + 1));
            }
            if (sum > max) {
                max = sum;
                ans = level;
            }
        }
        return ans;
    }
}
