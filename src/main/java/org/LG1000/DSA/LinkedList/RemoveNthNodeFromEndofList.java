package org.LG1000.DSA.LinkedList;

//19. Remove Nth Node From End of List
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curr=head;
        for(int i=0;i<n;i++){
            curr=curr.next;
        }
        while(curr!=null){
            curr=curr.next;
            prev=prev.next;
        }
        if(n==1){
            prev.next=null;
        }
        else{
            prev.next=prev.next.next;
        }
        return dummy.next;

    }
}
