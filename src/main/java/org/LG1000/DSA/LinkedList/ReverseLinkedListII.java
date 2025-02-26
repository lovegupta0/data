package org.LG1000.DSA.LinkedList;

//92. Reverse Linked List II
//https://leetcode.com/problems/reverse-linked-list-ii/description/
public class ReverseLinkedListII {
    private ListNode reverse(ListNode head){

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode p=dummy;
        p.next=head;
        for(int i=1;i<left;i++){
            p=p.next;
        }
        ListNode next=p.next;
        ListNode curr=p.next;
        for(int i=0;i<right-left;i++){
            curr=curr.next;
        }
        ListNode temp=null;
        if(curr!=null){
            temp=curr.next;
            curr.next=null;
        }

        p.next=reverse(p.next);
        next.next=temp;

        return dummy.next;

    }
}
