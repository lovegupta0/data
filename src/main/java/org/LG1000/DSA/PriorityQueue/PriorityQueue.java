package org.LG1000.DSA.PriorityQueue;
import java.util.*;
public class PriorityQueue<T extends Comparable<T>> {
    private List<T> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void add(T element) {
        heap.add(element);
        bubbleUp(heap.size() - 1);
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public T poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        T removedElement = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        bubbleDown(0);
        return removedElement;
    }

    private void bubbleDown(int index) {
        int leftChildIndex, rightChildIndex, minIndex;
        while (true) {
            leftChildIndex = 2 * index + 1;
            rightChildIndex = 2 * index + 2;
            minIndex = index;

            if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(minIndex)) < 0) {
                minIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(minIndex)) < 0) {
                minIndex = rightChildIndex;
            }

            if (minIndex != index) {
                swap(index, minIndex);
                index = minIndex;
            } else {
                break;
            }
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

