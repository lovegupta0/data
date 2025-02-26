package org.LG1000.DSA.LinkedList;

//61. Rotate List
//https://leetcode.com/problems/rotate-list/description/
public class RotateList {

    //Approach1
    class Approach1{
        public ListNode rotateRight(ListNode head, int k) {
            if(head==null || k==0 || head.next==null) return head;
            int count=1;
            ListNode p=head;
            while(p.next!=null){
                count++;
                p=p.next;
            }
            ListNode dummy=new ListNode(-200);
            ListNode curr=head;
            k=k%count;
            if(k==0) return head;
            for(int i=0;i<count-k-1;i++){
                curr=curr.next;
            }

            dummy.next=curr.next;
            curr.next=null;
            p.next=head;
            return dummy.next;


        }
    }

    //Approach2
    class Approach2{
        public ListNode rotateRight(ListNode head, int k) {
            if(head==null) return head;
            int size=1;
            ListNode p=head;
            while(p.next!=null){
                p=p.next;
                size++;
            }
            k=k%size;
            if(k==0) return head;
            ListNode curr=head;
            ListNode prev=head;

            while(k-- >0){
                curr=curr.next;

            }
            curr=curr.next;
            while(curr!=null){
                System.out.println(curr.val);
                curr=curr.next;
                prev=prev.next;

            }

            ListNode currHead=prev.next;
            prev.next=null;
            p.next=head;

            return currHead;


        }
    }
}
