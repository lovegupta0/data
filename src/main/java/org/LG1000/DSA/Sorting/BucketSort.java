package org.LG1000.DSA.Sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {
    public static void sort(int[] arr){
        int noOfBucket=(int)Math.floor(Math.sqrt(arr.length));
        int mxValue= Arrays.stream(arr).max().orElse(1);
        List<InsertionSort> bucketList=new ArrayList<>(noOfBucket);
        for(int i=0;i<noOfBucket;i++){
            bucketList.add(new InsertionSort());
        }
        for(int val:arr){
            int bucketIndex=(int) Math.ceil((val*noOfBucket)/mxValue);
            bucketIndex=bucketIndex<0?0:bucketIndex>=noOfBucket?noOfBucket-1:bucketIndex;
            bucketList.get(bucketIndex).add(val);
        }
        int k=0;
        for(InsertionSort lst:bucketList){
            for (int val:lst.getArray()){
                arr[k++]=val;
            }
            lst.clear();
        }
        bucketList.clear();
    }
}
