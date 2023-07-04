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
    private int maxSum;
    public int maxPathSum(TreeNode root) {

        /*
         * tc: n
         * sc: n
         */
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }
    
    public int helper(TreeNode root){
        
        if(root == null){
            return 0;
        }
        
        int leftValue = Math.max(helper(root.left), 0);
        int rightValue = Math.max(helper(root.right), 0);
        
        maxSum = Math.max(maxSum, leftValue + rightValue + root.val);
        
        return Math.max(root.val + leftValue, root.val + rightValue);
    }
}
