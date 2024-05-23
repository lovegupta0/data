package org.LG1000.DSA.Tree.BinarySearchTree;

import org.LG1000.DSA.Main;
import org.LG1000.DSA.Tree.TreeNode;

public class BinarySearchTree {
    public static TreeNode insert(TreeNode root,int val){
        if(root==null){
            root=new TreeNode(val);
            return root;
        }
        if(root.val>=val){
            root.left=insert(root.left,val);
        }
        else {
            root.right=insert(root.right,val);
        }
        return root;
    }
    public static Boolean search(TreeNode root,int val){
        if(root==null) return false;
        if(root.val==val) return true;
        else if(root.val>val){
            return search(root.left,val);
        }
        else {
            return search(root.right,val);
        }
    }

    public static TreeNode deleteNode(TreeNode root,int val){
        if(root==null) return root;
        if(root.val>val){
            root.left=deleteNode(root.left,val);
        }
        else if (root.val<val) {
            root.right=deleteNode(root.right,val);
        }
        else {
            if(root.left==null) return root.right;
            else if (root.right==null) return root.left;
            else if (root.left==null && root.right==null) {
                root=null;
            } else {
                root.val=minValue(root.right); // Node with two children: Get the inorder successor (smallest in the right subtree)
                root.right=deleteNode(root.right,root.val); // Delete the inorder successor
            }
        }

        return root;
    }
    private static int minValue(TreeNode root){
        int minVal=root.val;
        while (root.left!=null){
            root=root.left;
            minVal=root.val;
        }
        return minVal;
    }
}
