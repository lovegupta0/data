package org.LG1000.DSA.LinkedList;

//25. Reverse Nodes in k-Group
//https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class ReverseNodesink_Group {
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode();

        ListNode prev=dummy;

        while(head!=null){
            ListNode temp=head;
            int count=1;
            while(count<k && head.next!=null){
                head=head.next;
                count++;
            }
            if(count==k){
                ListNode next=head.next;
                head.next=null;
                prev.next=reverse(temp);
                prev=temp;
                head=next;
            }
            else{
                prev.next=temp;
                break;
            }

        }
        return dummy.next;
    }
}
