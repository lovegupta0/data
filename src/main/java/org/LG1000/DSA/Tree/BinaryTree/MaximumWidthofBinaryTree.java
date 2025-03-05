package org.LG1000.DSA.Tree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;
import java.util.*;

//662. Maximum Width of Binary Tree
//https://leetcode.com/problems/maximum-width-of-binary-tree/description/
public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Data> q=new LinkedList<>();
        int max=0;
        q.add(new Data(root,0));
        while(!q.isEmpty()){
            int t=q.size();
            Data a=q.peek();
            int initial=a.h;
            while(t-- >0){
                Data d=q.poll();
                max=Math.max(d.h-initial+1,max);
                if(d.p.left!=null){
                    q.add(new Data(d.p.left,d.h*2+1));
                }
                if(d.p.right!=null){
                    q.add(new Data(d.p.right,d.h*2+2));
                }
            }
        }

        return max;
    }
}
