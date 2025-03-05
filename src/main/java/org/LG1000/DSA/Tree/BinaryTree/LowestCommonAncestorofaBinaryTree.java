package org.LG1000.DSA.Tree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;

//236. Lowest Common Ancestor of a Binary Tree
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p || root==q) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null || right ==null){
            return left==null?right:left;
        }
        return root;

    }
}
