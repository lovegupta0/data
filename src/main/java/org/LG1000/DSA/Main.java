package org.LG1000.DSA;


import org.LG1000.DSA.PriorityQueue.PriorityQueue;

public class Main {
    public static void main(String[] args) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       pq.add(3);
       pq.add(1);
       pq.add(4);
       pq.add(2);

       System.out.println("Peek: " + pq.peek()); // Peek: 1

       while (!pq.isEmpty()) {
          System.out.println("Poll: " + pq.poll()); // Poll: 1, Poll: 2, Poll: 3, Poll: 4
       }
    }
}