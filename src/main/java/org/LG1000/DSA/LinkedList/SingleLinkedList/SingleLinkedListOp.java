package org.LG1000.DSA.LinkedList.SingleLinkedList;

import org.LG1000.DSA.LinkedList.Node;

public class SingleLinkedListOp {
    public static Node insert(Node head,int val){
        Node p=head;
        if(head==null){
            head=new  Node(val);
        }
        else {
            Node newNode=new Node(val);
            while (p.next!=null) p=p.next;
            p.next=newNode;
            newNode.next=null;
        }
        return head;
    }
    public static void print(Node head){
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    public static Node insertAtPos(Node head,int val,int pos){
        Node p=head;
        Node newNode=new Node(val);
        if (pos==1){
            newNode.next=head;
            return newNode;
        }
        while (head!=null && (pos-1)>1){
            head=head.next;
            pos--;
        }
        newNode.next=head.next;
        head.next=newNode;
        return p;
    }

    public static Node delete(Node head,int val){
        Node p=head;
        if(p.val==val){
            head=head.next;
            return head;
        }
        while (p.next!=null && p.next.val!=val){
            p=p.next;
        }
        p.next=p.next.next;
        return head;
    }
}
