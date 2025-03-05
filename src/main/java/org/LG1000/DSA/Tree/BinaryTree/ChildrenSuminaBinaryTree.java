package org.LG1000.DSA.Tree.BinaryTree;

//Children Sum in a Binary Tree
//https://www.geeksforgeeks.org/problems/children-sum-parent/1
public class ChildrenSuminaBinaryTree {
    public static int isSumProperty(Node root)
    {
        if(root==null || (root.left==null && root.right==null)) return 1;
        int val=0;
        if(root.left!=null) val+=root.left.data;
        if(root.right!=null) val+=root.right.data;

        if(val!=root.data) return 0;

        return isSumProperty(root.left) & isSumProperty(root.right);

    }
}
