package org.LG1000.DSA.LinkedList;

//Flattening a Linked List
//https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
public class FlatteningaLinkedList {
    Node merge(Node a,Node b){
        if(a==null || b==null) return a==null?b:a;

        if(a.data<b.data){
            a.bottom=merge(a.bottom,b);
            return a;
        }
        else{
            b.bottom=merge(a,b.bottom);
            return b;
        }
    }
    Node flatten(Node root) {
        if(root==null) return null;
        Node p=root;
        while(p!=null){
            p=p.next;
            root=merge(root,p);
        }
        return root;
    }
}
class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}

