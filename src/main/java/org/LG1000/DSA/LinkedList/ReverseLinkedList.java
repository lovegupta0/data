package org.LG1000.DSA.LinkedList;

//206. Reverse Linked List
//https://leetcode.com/problems/reverse-linked-list/description/
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode next=null;
        while(head!=null){
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}
