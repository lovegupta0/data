package org.LG1000.DSA.LinkedList;

//83. Remove Duplicates from Sorted List
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode curr=head.next;
        ListNode prev=head;
        while(curr!=null){
            if(prev.val==curr.val){
                ListNode next=curr.next;
                prev.next=curr.next;
                curr=next;
            }
            else {
                prev=prev.next;
                curr=curr.next;
            }

        }
        return head;
    }
}
