package org.LG1000.DSA.Sorting;

public class SelectionSort {
    public static void sort(int[] arr){
        for(int i=0;i< arr.length-1;i++){
            int minIdx=i;
            for(int j=i+1;j< arr.length;j++){
                if(arr[minIdx]>arr[j]){
                    minIdx=j;
                }
            }
            if(i!=minIdx){
                int temp=arr[minIdx];
                arr[minIdx]=arr[i];
                arr[i]=temp;
            }
        }
    }
}
