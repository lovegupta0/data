package org.LG1000.DSA.Tree.BinaryHeap;

import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> lst;
    private int size;
    private int index;
    private int start_index;
    public MinHeap(){
        lst=new ArrayList<>();
        lst.add(Integer.MIN_VALUE);
        this.index=1;
        this.size=0;
        this.start_index=1;
    }
    public void insert(int val){
        if(size==0){
            lst.add(val);
            index++;
            size++;
            return;
        }
        lst.add(val);
        index++;
        size++;
        heapifyUp(index-1);
    }
    private void heapifyUp(int k){
        if(1<k){
            if(lst.get(k/2)>lst.get(k)){
                int temp=lst.get(k/2);
                lst.set(k/2,lst.get(k));
                lst.set(k,temp);
                heapifyUp(k/2);
            }
        }
    }
    public int peek(){
        if(size==0) throw new  RuntimeException("Heap is empty");
        return lst.get(1);
    }
    public int pop(){
        if(size==0) throw new  RuntimeException("Heap is empty");
        size--;
        int res= lst.get(1);
        lst.set(1,lst.get(lst.size()-1));
        lst.remove(lst.size()-1);
        heapifyDown(1);
        return res;
    }
    private void heapifyDown(int k){
        int left=2*k;
        int right =2*k+1;
        if(left<=size){
            if(lst.get(k)>lst.get(left)){
                swap(k,left);
                heapifyDown(left);
            }
        }
        if(right<=size){
            if(lst.get(k)>lst.get(right)){
                swap(k,right);
                heapifyDown(right);
            }
        }
    }
    private void swap(int a,int b){
        int temp=lst.get(a);
        lst.set(a,lst.get(b));
        lst.set(b,temp);
    }
}
