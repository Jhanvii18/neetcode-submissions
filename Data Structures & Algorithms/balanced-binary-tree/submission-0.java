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

class Solution 
{
    int size(TreeNode root)
    {
        if(root==null)
        return 0;

        int ls = size(root.left);
        int rs = size(root.right);

        return 1+Math.max(ls,rs);
    }
    public boolean isBalanced(TreeNode root) 
    {
        if(root==null)
        return true;

        int ls = size(root.left);
        int rs = size(root.right);

        return((Math.abs(ls-rs)<=1)&&isBalanced(root.left)&&isBalanced(root.right));
    }
}
