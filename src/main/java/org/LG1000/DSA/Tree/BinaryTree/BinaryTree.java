package org.LG1000.DSA.Tree.BinaryTree;

import org.LG1000.DSA.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private TreeNode node;
    public void insert(int val){
        if(node==null){
            this.node=new TreeNode(val);
        }

        else {
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()){
                TreeNode root=queue.poll();
                if(root.left!=null) queue.add(root.left);
                else {
                    root.left=new TreeNode(val);
                    break;
                }
                if(node.right!=null) queue.add(node.right);
                else {
                    root.right=new TreeNode(val);
                    break;
                }
            }
        }
    }
    public static void preOrderTraversal(TreeNode root){
        if(root==null) return;
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(TreeNode root){
        if(root==null) return;
        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(TreeNode root){
        if(root==null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val);

    }

    public static void levelOrderTraversal(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            System.out.println(node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
    }

    private TreeNode getNode(TreeNode root){
        if(root==null) return root;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.left!=null) queue.add(node.left);
            else return node;
            if(node.right!=null) queue.add(node.right);
            else return node;
        }
        return root;
    }

}
