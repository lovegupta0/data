package org.LG1000.DSA.LinkedList;

//234. Palindrome Linked List
//https://leetcode.com/problems/palindrome-linked-list/description/
public class PalindromeLinkedList {
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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        //This while loop condition is imp.
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=reverse(slow.next);
        slow=slow.next;
        while(slow!=null){
            if(slow.val!=head.val) return false;
            slow=slow.next;
            head=head.next;
        }

        return true;
    }
}
