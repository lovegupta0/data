package org.LG1000.DSA.Sorting;

public class MergeSort {
    public static void sort(int[] arr){
        mergeSort(arr,0, arr.length-1);
    }
    private static void mergeSort(int[] arr,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }

    private static void merge(int[] arr,int l,int m,int r){
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        // Merge the temporary arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private void merge1(int[] nums,int l,int m,int r){
        int i=l;
        int j=m+1;
        int[] temp=new int[r-l+1];
        int k=0;
        while(i<=m && j<=r){
            if(nums[i]<nums[j]){
                temp[k++]=nums[i++];
            }
            else{
                temp[k++]=nums[j++];
            }
        }
        while(i<=m){
            temp[k++]=nums[i++];
        }
        while(j<=r){
            temp[k++]=nums[j++];
        }
        for(i=0;i<temp.length;i++){
            nums[i+l]=temp[i];
        }
    }
    private void mergeSort1(int[] nums,int l,int r){
        if(l<r){
            int m=l+(r-l)/2;
            mergeSort1(nums,l,m);
            mergeSort1(nums,m+1,r);
            merge1(nums,l,m,r);
        }
    }
    public void sortArray(int[] nums) {
        mergeSort1(nums,0,nums.length-1);
    }
}
