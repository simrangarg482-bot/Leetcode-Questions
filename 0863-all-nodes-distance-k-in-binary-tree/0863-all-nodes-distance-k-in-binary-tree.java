class Solution {
    private void buildParent(TreeNode node, TreeNode par) {
        if (node == null) {
            return;
        }
        parent.put(node, par);
        buildParent(node.left, node);
        buildParent(node.right, node);
    }
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        // Step 1: create parent mapping
        buildParent(root, null);
        // Step 2: BFS from target
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.add(target);
        visited.add(target);
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            // We reached distance k
            if (distance == k) {
                while (size > 0) {
                    TreeNode node = q.poll();
                    ans.add(node.val);
                    size--;
                }
                return ans;
            }
            while (size > 0) {
                TreeNode node = q.poll();
                // left child
                if (node.left != null &&
                    !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.add(node.left);
                }
                // right child
                if (node.right != null &&
                    !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.add(node.right);
                }
                // parent
                TreeNode par = parent.get(node);
                if (par != null &&
                    !visited.contains(par)) {
                    visited.add(par);
                    q.add(par);
                }
                size--;
            }
            distance++;
        }
        return ans;
    }
}