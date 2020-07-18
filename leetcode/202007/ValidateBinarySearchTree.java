// Date: 18 Jul 2020

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    public boolean helper(TreeNode root, Integer lower, Integer higher) {
        // recursive end condition
        if (root == null) {
            return true;
        }
        if (lower != null && root.val <= lower) {
            return false;
        }
        if (higher != null && root.val >= higher) {
            return false;
        }

        boolean isLeftValid = helper(root.left, lower, root.val);
        boolean isRightValid = helper(root.right, root.val, higher);
        return isLeftValid && isRightValid;
    }
}
