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
        // check root node
        if (root.left != null) {
            if (root.val <= root.left.val) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val >= root.right.val) {
                return false;
            }
        }
        // check right sub tree
        if (lower == null) lower = root.val;
        boolean isLeftValid = helper(root.left, lower, null);
        // check left tree
        if (higher == null) higher = root.val;
        boolean isRightValid = helper(root.right, null, higher);
        // if one of them are false, return false. Otherwise, return true
        return isLeftValid && isRightValid;
    }
}
