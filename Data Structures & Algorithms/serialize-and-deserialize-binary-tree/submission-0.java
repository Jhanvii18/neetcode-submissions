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

public class Codec 
{
    int i =0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        StringBuilder sb = new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }

    void preorder(TreeNode root,StringBuilder sb)
    {
        if(root==null)
        {
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        preorder(root.left,sb);
        preorder(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        String[] arr = data.split(",");
        i=0;
        return build(arr);
    }
    TreeNode build(String[] arr)
    {
        if(arr[i].equals("N"))
        {
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[i]));
        i++;
        root.left=build(arr);
        root.right=build(arr);
        return root;
    }
}
