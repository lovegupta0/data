package org.LG1000.DSA.Sorting;

public class Main {
    public static void print(int[] arr){
        for(int val: arr){
            System.out.print(val+" ");
        }
        System.out.println("\n");
    }
    public static void main(String[] args) {

        int[] arr={5,6,7,4,11,8,70,50,60,40,80,55,1};
        System.out.println("Recursion sort");
        print(RecursionSort.sort(arr));
        System.out.println("Quick Sort");
        QuickSort.sort(arr);
        print(arr);
        System.out.println("Merge Sort");
        MergeSort.sort(arr);
        print(arr);
        System.out.println("Bucket Sort");
        BucketSort.sort(arr);
        print(arr);
        System.out.println("Insertion Sort");
        InsertionSort.sort(arr);
        print(arr);
        System.out.println("Selection Sort");
        SelectionSort.sort(arr);
        print(arr);
        System.out.println("Bubble Sort");
        BubbleSorting.sort(arr);
        print(arr);

    }
}
