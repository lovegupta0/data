package org.LG1000.DSA.Tree.BinarySearchTree;

import org.LG1000.DSA.PriorityQueue.PriorityQueue;
import org.LG1000.DSA.Tree.BinaryHeap.MinHeap;
import org.LG1000.DSA.Tree.BinaryTree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;

public class Main {
    public static void main(String[] args) {

        int[] arr={100,20,50,70,60,120,200,150};
        MinHeap m=new MinHeap();
        for (int i:arr){
            m.insert(i);
        }
        for (int i:arr){
            System.out.println(m.pop());
        }
    }
}
