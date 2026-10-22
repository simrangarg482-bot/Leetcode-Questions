class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0) {
            int size = q.size();
            int count = 0;
            double val = 0;
            for(int i=0; i<size; i++) {
                TreeNode top = q.poll();
                val += top.val; 
                count++;
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            }
            Double res = val/count;
            ans.add(res);
        }
        return ans;
    }
}