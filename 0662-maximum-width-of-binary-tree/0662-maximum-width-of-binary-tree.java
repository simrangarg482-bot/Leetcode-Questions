class Solution {
    public class pair {
        TreeNode node;
        long index;
        pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root, 0));
        int maxWidth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            long first = q.peek().index;
            long last = first;
            for(int i=0; i<size; i++) {
                pair curr = q.poll();
                last = curr.index;
                if(curr.node.left != null) {
                    q.add(new pair(curr.node.left, 2* curr.index + 1));
                }
                if(curr.node.right != null) {
                    q.add(new pair(curr.node.right, 2* curr.index + 2));
                }
            }
            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }
        return maxWidth;
    }
}