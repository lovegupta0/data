package org.LG1000.DSA.Sorting;

import java.util.*;

public class RecursionSort {
    public static int[] sort(int[] arr){
        if(arr.length<=1) return arr;
        List<Integer> res=new ArrayList<>();
        makeSort(arr, arr.length -1,res);
        return res.stream().mapToInt(e->(int)e).toArray();
    }
    private static void makeSort(int[] arr, int k,List<Integer> res){
        if(k==0){
            res.add(arr[k]);
            return;
        }
        makeSort(arr,k-1,res);
        insert(res,arr[k]);
    }
    private static void insert(List<Integer> res,int val){
        if(res.size()==0 || res.get(res.size()-1)<val) {
            res.add(val);
            return;
        }
        int temp=res.get(res.size()-1);
        res.remove(res.size()-1);
        insert(res,val);
        res.add(temp);
    }
}
