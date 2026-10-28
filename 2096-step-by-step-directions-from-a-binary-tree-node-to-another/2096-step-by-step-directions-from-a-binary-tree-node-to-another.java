class Solution {
    private boolean findPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) return false;
        if (root.val == target) return true;
        path.append('L');
        if (findPath(root.left, target, path)) return true;
        path.deleteCharAt(path.length() - 1);
        path.append('R');
        if (findPath(root.right, target, path)) return true;
        path.deleteCharAt(path.length() - 1);
        return false;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();
        findPath(root, startValue, startPath);
        findPath(root, destValue, destPath);
        int i = 0;
        while (i < startPath.length() && i < destPath.length() && startPath.charAt(i) == destPath.charAt(i)) {
            i++;
        }
        StringBuilder ans = new StringBuilder();
        for (int j = i; j < startPath.length(); j++) {
            ans.append('U');
        }
        ans.append(destPath.substring(i));
        return ans.toString();
    }
}