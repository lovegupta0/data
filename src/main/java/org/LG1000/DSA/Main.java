package org.LG1000.DSA;


import org.LG1000.DSA.LinkedList.DoubleLinkedList.DoubleLinkedListOp;

import org.LG1000.DSA.LinkedList.SingleLinkedList.SingleLinkedListOp;

public class Main {
    public static void main(String[] args) {
       DoubleLinkedListOp list = new DoubleLinkedListOp();
       list.insert(10); // Insertion at the end
       list.insertAtBeginning(5); // Insertion at the beginning
       list.insertAtPosition(7, 2); // Insertion at position 2
       list.insert(15); // Insertion at the end
       list.insert(20); // Insertion at the end
       list.display(); // Display the list: 5 7 10 15 20

       list.deleteAtBeginning(); // Deletion at the beginning
       list.deleteAtEnd(); // Deletion at the end
       list.deleteAtPosition(2); // Deletion at position 2
       list.display(); // Display the list after deletions: 7 15

       list.deleteValue(7); // Deletion of value 7
       list.display(); // Display the list after deletion of value 7: 15
    }
}