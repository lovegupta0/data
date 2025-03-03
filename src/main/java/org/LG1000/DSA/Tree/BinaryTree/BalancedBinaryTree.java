package org.LG1000.DSA.Tree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;
//110. Balanced Binary Tree
//https://leetcode.com/problems/balanced-binary-tree/description/

public class BalancedBinaryTree {
    boolean result=true;
    private int check(TreeNode root){
        if(root==null) return 0;
        int l=1+check(root.left);
        int r=1+check(root.right);

        if(Math.abs(l-r)>1) result=false;
        return Math.max(l,r);
    }
    public boolean isBalanced(TreeNode root) {
        check(root);
        return result;
    }
}
