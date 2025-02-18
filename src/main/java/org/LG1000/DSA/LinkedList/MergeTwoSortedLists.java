package org.LG1000.DSA.LinkedList;

//21. Merge Two Sorted Lists
//https://leetcode.com/problems/merge-two-sorted-lists/description/
public class MergeTwoSortedLists {

    //Approach1
    class Approach1{
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy=new ListNode();
            ListNode prev=dummy;
            while(list1!=null && list2!=null){
                if(list1.val<list2.val){
                    prev.next=list1;
                    list1=list1.next;
                }
                else{
                    prev.next=list2;
                    list2=list2.next;
                }
                prev=prev.next;
            }

            if(list1!=null){
                prev.next=list1;
            }
            if(list2!=null){
                prev.next=list2;
            }

            return dummy.next;
        }
    }

    //Approach2
    class Approach2{
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1==null) return list2;
            ListNode p=list1;
            ListNode prev=list1;
            while(list1!=null && list2!=null){
                if(list1.val>=list2.val){
                    ListNode newNode=new ListNode(list1.val);
                    list1.val=list2.val;
                    ListNode next=list1.next;
                    list1.next=newNode;
                    newNode.next=next;
                    list2=list2.next;
                }
                prev=list1;
                list1=list1.next;
            }
            while(list2!=null){
                ListNode newNode=new ListNode(list2.val);
                prev.next=newNode;
                prev=prev.next;
                list2=list2.next;
            }
            return p;
        }
    }

    //Approach3
    class Approach3{
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1==null || list2==null) return list1==null?list2:list1;

            if(list1.val<list2.val){
                list1.next=mergeTwoLists(list1.next,list2);
                return list1;
            }
            else{
                list2.next=mergeTwoLists(list1,list2.next);
                return list2;
            }


        }
    }


}
