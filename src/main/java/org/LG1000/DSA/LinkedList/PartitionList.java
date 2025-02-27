package org.LG1000.DSA.LinkedList;

//86. Partition List
//https://leetcode.com/problems/partition-list/description/
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);

        ListNode smallP = small;
        ListNode largeP = large;

        while(head != null) {

            if(head.val < x) {
                smallP.next = head;
                smallP = smallP.next;
            } else {
                largeP.next = head;
                largeP = largeP.next;
            }

            head = head.next;

        }


        smallP.next = large.next;
        largeP.next = null;

        return small.next;
    }
}
