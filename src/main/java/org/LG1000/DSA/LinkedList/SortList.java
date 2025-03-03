package org.LG1000.DSA.LinkedList;

//148. Sort List
//https://leetcode.com/problems/sort-list/description/
public class SortList {
    private ListNode get(ListNode l1,ListNode l2){
        if(l1==null || l2==null) return l1==null?l2:l1;
        if(l1.val<l2.val){
            l1.next=get(l1.next,l2);
            return l1;
        }
        else{
            l2.next=get(l1,l2.next);
            return l2;
        }
    }
    public ListNode sortList(ListNode head) {
        if(head==null) return head;
        ListNode fast=head;
        ListNode slow=head;
        ListNode prev=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        if(slow==fast) return head;
        prev.next=null;
        ListNode a=sortList(head);
        ListNode b=sortList(slow);
        return get(a,b);
    }
}
