package org.LG1000.DSA.LinkedList;

//141. Linked List Cycle
//https://leetcode.com/problems/linked-list-cycle/description/
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) return true;
        }

        return false;
    }
}
