package org.LG1000.DSA.Tree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;
import java.util.*;

//199. Binary Tree Right Side View
//https://leetcode.com/problems/binary-tree-right-side-view/description/
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lst=new ArrayList<>();
        if(root==null) return lst;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode p=q.poll();
                if(i==(n-1)){
                    lst.add(p.val);
                }
                if(p.left!=null) q.add(p.left);
                if(p.right!=null) q.add(p.right);
            }
        }
        return lst;
    }
}
