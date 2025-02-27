package org.LG1000.DSA.LinkedList;

//82. Remove Duplicates from Sorted List II
//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode pprev=dummy;
        ListNode prev=head;
        ListNode curr=head.next;
        while(curr!=null){
            if(prev.val==curr.val){
                while(curr!=null && prev.val==curr.val){
                    prev=prev.next;
                    curr=curr.next;
                }
                pprev.next=curr;
                prev=curr;
                if(curr!=null) curr=curr.next;

            }
            else{
                pprev=pprev.next;
                prev=curr;
                curr=curr.next;
            }
        }

        return dummy.next;

    }
}
