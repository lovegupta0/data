package org.LG1000.DSA.Tree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;

//101. Symmetric Tree
//https://leetcode.com/problems/symmetric-tree/description/
public class SymmetricTree {
    private boolean check(TreeNode r1,TreeNode r2){
        if(r1==null && r2==null) return true;
        if(r1==null || r2==null || r1.val!=r2.val) return false;

        return check(r1.left,r2.right) && check(r1.right,r2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
}
