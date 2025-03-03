package org.LG1000.DSA.Tree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;
import java.util.*;

//103. Binary Tree Zigzag Level Order Traversal
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lst=new ArrayList<>();
        if(root==null) return lst;
        Queue<TreeNode> q=new LinkedList<>();
        int lvl=0;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int t=q.size();
            while(t-- >0){
                TreeNode p=q.poll();
                temp.add(p.val);
                if(p.left!=null) q.add(p.left);
                if(p.right!=null) q.add(p.right);
            }
            if(lvl%2>0){
                int l=0;
                int r=temp.size()-1;
                while(l<r){
                    int tVal=temp.get(l);
                    temp.set(l,temp.get(r));
                    temp.set(r,tVal);
                    l++;
                    r--;
                }
            }

            lst.add(temp);
            lvl++;
        }

        return lst;
    }
}
