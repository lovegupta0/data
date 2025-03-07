package org.LG1000.DSA.Tree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;

//105. Construct Binary Tree from Preorder and Inorder Traversal
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    private TreeNode get(int[] preorder, int[] inorder, int is,int ie,int[] ps){
        if(is>ie) return null;

        TreeNode root=new TreeNode(preorder[ps[0]]);
        int i=is;
        for(;i<=ie;i++){
            if(inorder[i]==preorder[ps[0]]) break;
        }
        ps[0]++;
        root.left=get(preorder,inorder,is,i-1,ps);
        root.right=get(preorder,inorder,i+1,ie,ps);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        int[] ps=new int[1];
        ps[0]=0;
        return get(preorder,inorder,0,n-1,ps);
    }
}
