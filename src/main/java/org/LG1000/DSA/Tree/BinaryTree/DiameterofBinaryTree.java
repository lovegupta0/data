package org.LG1000.DSA.Tree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;

//543. Diameter of Binary Tree
//https://leetcode.com/problems/diameter-of-binary-tree/description/
public class DiameterofBinaryTree {
    int res;
    private int get(TreeNode root){
        if(root==null) return 0;

        int l=get(root.left);
        int r=get(root.right);
        int temp=1+ Math.max(l,r);
        int ans=Math.max(temp,l+r+1);
        res=Math.max(res,ans);
        return temp;

    }
    public int diameterOfBinaryTree(TreeNode root) {
        res=Integer.MIN_VALUE;
        get(root);
        return res-1;
    }
}

