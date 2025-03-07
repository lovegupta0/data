package org.LG1000.DSA.Tree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;

//114. Flatten Binary Tree to Linked List
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
public class FlattenBinaryTreetoLinkedList {
    //Approach 1
    // T.C. -> O(N) & S.C. -> O(N)
    class Approach1{
        TreeNode prev=null;
        public void flatten(TreeNode root) {
            if(root==null) return;
            flatten(root.right);
            flatten(root.left);

            root.right=prev;
            root.left=null;
            prev=root;
        }
    }

    //Approach2
    //T.C. -> O(N) & S.C. -> O(1)
    class Approach2{
        public void flatten(TreeNode root) {
            if(root==null) return;
            TreeNode curr=root;

            while(curr!=null){
                if(curr.left!=null){
                    TreeNode prev=curr;
                    TreeNode next=curr.left;
                    while(next!=null){
                        prev=next;
                        next=next.right;
                    }
                    prev.right=curr.right;
                    curr.right=curr.left;
                    curr.left=null;
                }
                curr=curr.right;
            }
        }
    }
}
