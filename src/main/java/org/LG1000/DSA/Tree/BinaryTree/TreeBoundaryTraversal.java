package org.LG1000.DSA.Tree.BinaryTree;
import java.util.*;

//Tree Boundary Traversal
//https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
public class TreeBoundaryTraversal {
    private void getLeftSide(Node root,LinkedHashSet<Node> left){
        if(root==null) return;
        left.add(root);
        getLeftSide(root.left,left);
        if(root.left==null)  getLeftSide(root.right,left);
    }
    private void getRightSide(Node root,LinkedHashSet<Node> right){
        if(root==null) return;

        getRightSide(root.right,right);
        if(root.right==null) getRightSide(root.left,right);
        right.add(root);
    }

    private void getLeafNode(Node root,LinkedHashSet<Node> leaf){
        if(root==null) return;
        getLeafNode(root.left,leaf);
        if(root.left==null && root.right==null) leaf.add(root);
        getLeafNode(root.right,leaf);
    }
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> lst=new ArrayList<>();
        LinkedHashSet<Node> left=new LinkedHashSet<>();
        LinkedHashSet<Node> leaf=new LinkedHashSet<>();
        LinkedHashSet<Node> right=new LinkedHashSet<>();
        left.add(node);
        getLeftSide(node.left,left);
        getLeafNode(node,leaf);
        getRightSide(node.right,right);

        for(Node p:left){
            lst.add(p.data);
        }
        for(Node p:leaf){
            if(!left.contains(p)){
                lst.add(p.data);
            }
        }

        for(Node p:right){
            if(!left.contains(p) && !leaf.contains(p)){
                lst.add(p.data);
            }
        }

        return lst;

    }
}

class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
