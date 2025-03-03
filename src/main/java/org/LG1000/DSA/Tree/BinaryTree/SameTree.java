package org.LG1000.DSA.Tree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;

//100. Same Tree
//https://leetcode.com/problems/same-tree/description/
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null || p.val!=q.val) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}
