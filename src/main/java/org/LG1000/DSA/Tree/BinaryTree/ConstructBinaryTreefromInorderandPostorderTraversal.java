package org.LG1000.DSA.Tree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;

//106. Construct Binary Tree from Inorder and Postorder Traversal
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    private TreeNode get(int[] inorder, int[] postorder,int is,int ie,int ps,int pe){
        if(is>ie) return null;
        int rootVal=postorder[pe];
        int i=is;
        for(;i<=ie;i++){
            if(inorder[i]==rootVal) break;
        }
        int leftSize=i-is;
        int rightSize=ie-i;
        TreeNode root=new TreeNode(rootVal);
        root.left=get(inorder,postorder,is,i-1,ps,ps+leftSize-1);
        root.right=get(inorder,postorder,i+1,ie,pe-rightSize,pe-1);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length-1;
        int[] idx=new int[1];
        idx[0]=n;

        return get(inorder,postorder,0,n,0,n);

    }
}
