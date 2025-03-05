package org.LG1000.DSA.Tree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;

//222. Count Complete Tree Nodes
//https://leetcode.com/problems/count-complete-tree-nodes/description/
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        return 1+ countNodes(root.left) + countNodes(root.right);
    }
}
