package org.LG1000.DSA.LinkedList;

//142. Linked List Cycle II
//https://leetcode.com/problems/linked-list-cycle-ii/description/
public class LinkedListCycleII {
    private ListNode get(ListNode head,ListNode slow){
        while(head!=null){
            if(head==slow) return head;
            head=head.next;
            slow=slow.next;
        }

        return head;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return get(head,slow);
            }
        }

        return null;

    }
}
