class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode startNode = null;
        // Step 1: Store each node's parent
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.val == start) {
                startNode = curr;
            }
            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.add(curr.right);
            }
        }
        // Step 2: Spread infection using BFS
        Set<TreeNode> visited = new HashSet<>();
        q.add(startNode);
        visited.add(startNode);
        int time = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                TreeNode p = parent.get(curr);
                if (p != null && !visited.contains(p)) {
                    q.add(p);
                    visited.add(p);
                }
            }
        }
        return time;
    }
}