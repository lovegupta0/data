package org.LG1000.DSA.Sorting;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
    private List<Integer> lst;
    public InsertionSort(){
        lst=new ArrayList<>();
    }
    public static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i;
            while (j>0 && arr[j-1]>arr[j]){
                int temp=arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=temp;
                j--;
            }
        }
    }
    public void add(int val){
        lst.add(val);
        int j=lst.size()-1;
        while (j>0 && lst.get(j-1)> lst.get(j)){
            swap(j-1,j);
            j--;
        }
    }
    public int get(int i){
        return lst.get(i);
    }
    private void swap(int a,int b){
        int temp=lst.get(a);
        lst.set(a,lst.get(b));
        lst.set(b,temp);
    }
    public void remove(int i){
        lst.remove(i);
    }
    public int[] getArray(){
        return lst.stream().mapToInt(Integer::intValue).toArray();
    }
    public void clear(){
        lst.clear();
    }
    public int getSize(){
        return lst.size();
    }
}
