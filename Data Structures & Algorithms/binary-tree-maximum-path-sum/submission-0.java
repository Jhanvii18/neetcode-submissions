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
 find maximum at each node and store
 val+max.left+max.right
 max among these is the maximum answer
 */

class Solution 
{
    int ans =Integer.MIN_VALUE;
    int maxi(TreeNode root)
    {
        if(root==null)
        return 0;

        // it is very veyr veyr important to prevent - values so:
        int ls = Math.max(0,maxi(root.left));
        int rs = Math.max(0,maxi(root.right));

        int curr = root.val+ls+rs;
        ans = Math.max(ans,curr);

        return root.val+Math.max(ls,rs);
    }
    public int maxPathSum(TreeNode root) 
    {
         maxi(root);
        return ans;
    }
}
