/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxDiam = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiam;
    }

    private int height(TreeNode root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        maxDiam = Math.max( maxDiam , (left + right) );
        return 1 + Math.max(left , right);
    }
}