package org.LG1000.DSA.LinkedList;

//237. Delete Node in a Linked List
//https://leetcode.com/problems/delete-node-in-a-linked-list/description/
public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;

    }
}
