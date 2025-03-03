package org.LG1000.DSA.Tree.BinaryTree;

import org.LG1000.DSA.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//104. Maximum Depth of Binary Tree
//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
public class MaximumDepthofBinaryTree {

    //Approach1
    //BFS
    class Approach1{
        public int maxDepth(TreeNode root) {
            if(root==null) return 0;
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root);
            int count=0;
            while(!q.isEmpty()){
                int n=q.size();
                count++;
                for(int i=0;i<n;i++){
                    TreeNode p=q.poll();
                    if(p.left!=null) q.add(p.left);
                    if(p.right!=null) q.add(p.right);
                }
            }
            return count;
        }
    }

    //Approach2
    //uisng Recursion
    class Approach2{
        public int maxDepth(TreeNode root) {
            if(root==null) return 0;
            return Math.max(1+maxDepth(root.left),1+maxDepth(root.right));
        }
    }
}
