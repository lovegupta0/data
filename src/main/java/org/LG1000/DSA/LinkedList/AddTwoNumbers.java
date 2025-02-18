package org.LG1000.DSA.LinkedList;

//2. Add Two Numbers
//https://leetcode.com/problems/add-two-numbers/description/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode p=l1;
        ListNode prev=l1;
        while(l1!=null && l2!=null){
            int res=l1.val+l2.val+carry;
            l1.val=res%10;
            carry=res/10;
            prev=l1;
            l1=l1.next;
            l2=l2.next;
        }
        while(l2!=null){
            int res=l2.val+carry;
            ListNode newNode=new ListNode(res%10);
            prev.next=newNode;
            carry=res/10;
            l2=l2.next;
            prev=prev.next;

        }
        while(l1!=null){
            int res=l1.val+carry;
            l1.val=res%10;
            carry=res/10;
            prev=l1;
            l1=l1.next;
        }
        if(carry>0){
            ListNode newNode=new ListNode(carry);
            prev.next=newNode;
        }
        return p;
    }
}
