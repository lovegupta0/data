package org.LG1000.DSA.DP.DPOnTree;

//124. Binary Tree Maximum Path Sum
//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
public class BinaryTreeMaximumPathSum {
    private int get(TreeNode root,int[] res){
        if(root==null) return 0;
        int l=get(root.left,res);
        int r=get(root.right,res);
        int temp=Math.max(Math.max(l,r)+root.val,root.val);
        int ans=Math.max(temp,l+r+root.val);
        res[0]=Math.max(res[0],ans);
        return temp;
    }
    public int maxPathSum(TreeNode root) {
        int[] res=new int[1];
        res[0]=Integer.MIN_VALUE;
        get(root,res);
        return res[0];
    }
}
