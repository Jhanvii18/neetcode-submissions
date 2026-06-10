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
    int max = Integer.MIN_VALUE;
    int size(TreeNode root)
    {
        if(root==null)
        return 0;

        int ls = size(root.left);
        int rs = size(root.right);

        return 1+Math.max(ls,rs);
    }
    public int diameterOfBinaryTree(TreeNode root) 
    {
        if(root==null)
        return 0;
        
        int curr = size(root.left)+size(root.right);

        return Math.max(curr,Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));
    }
}
