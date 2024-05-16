package org.LG1000.DSA.LinkedList.DoubleLinkedList;

import org.LG1000.DSA.LinkedList.DoubleNode;

public class DoubleLinkedListOp {
    private DoubleNode head;
    private DoubleNode tail;

    // Insertion at the end
    public void insert(int data) {
        DoubleNode newNode = new DoubleNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Insertion at the beginning
    public void insertAtBeginning(int data) {
        DoubleNode newNode = new DoubleNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insertion at a specific position
    public void insertAtPosition(int data, int pos) {
        if (pos <= 0) {
            insertAtBeginning(data);
            return;
        }

        DoubleNode newNode = new DoubleNode(data);
        DoubleNode current = head;
        int count = 1;
        while (current != null && count < pos) {
            current = current.next;
            count++;
        }

        if (current == null) {
            insert(data); // Insert at the end if position exceeds the size of the list
            return;
        }

        newNode.next = current;
        newNode.prev = current.prev;
        if (current.prev != null) {
            current.prev.next = newNode;
        } else {
            head = newNode;
        }
        current.prev = newNode;
    }

    // Deletion at the beginning
    public void deleteAtBeginning() {
        if (head == null) {
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // If the list becomes empty
        }
    }

    // Deletion at the end
    public void deleteAtEnd() {
        if (tail == null) {
            return;
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // If the list becomes empty
        }
    }

    // Deletion at a specific position
    public void deleteAtPosition(int pos) {
        if (pos <= 0 || head == null) {
            return;
        }
        if (pos == 1) {
            deleteAtBeginning();
            return;
        }

        DoubleNode current = head;
        int count = 1;
        while (current != null && count < pos) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return; // Position exceeds the size of the list
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev; // If deleting the last node
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next; // If deleting the first node
        }
    }

    // Deletion of a specific value present in the list
    public void deleteValue(int data) {
        DoubleNode current = head;
        while (current != null) {
            if (current.data == data) {
                if (current == head) {
                    deleteAtBeginning();
                } else if (current == tail) {
                    deleteAtEnd();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    // Display method to print the list
    public void display() {
        DoubleNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
