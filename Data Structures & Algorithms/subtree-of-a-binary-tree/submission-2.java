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
    void preorder(TreeNode root,StringBuilder sb)
    {
        if(root==null)
        {
            sb.append(",#");
            return;
        }
        sb.append(",").append(root.val);
        preorder(root.left,sb);
        preorder(root.right,sb);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {
        StringBuilder st1 = new StringBuilder();
        StringBuilder st2 = new StringBuilder();
        preorder(root,st1);
        preorder(subRoot,st2);

        if(st1.toString().contains(st2.toString()))
        return true;

        else
        return false;
    }
}
