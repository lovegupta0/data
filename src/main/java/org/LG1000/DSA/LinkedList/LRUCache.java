package org.LG1000.DSA.LinkedList;
import java.util.*;

//146. LRU Cache
//https://leetcode.com/problems/lru-cache/description/
public class LRUCache {
    DNode front;
    DNode end;
    int size;
    Map<Integer,DNode> map;

    public LRUCache(int capacity) {
        front=new DNode();
        end=front;
        size=capacity;
        map=new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            DNode curr=map.get(key);
            moveAtTheEnd(curr);
            return curr.val;
        }

        return -1;
    }
    private void moveAtTheEnd(DNode curr){
        if(end==curr) return;
        DNode prev=curr.prev;
        DNode next=curr.next;
        next.prev=prev;
        prev.next=next;
        end.next=curr;
        curr.prev=end;
        end=end.next;
    }
    private void addNode(int key, int value){
        if(map.containsKey(key)){
            map.get(key).val=value;
            moveAtTheEnd(map.get(key));
            return;
        }
        DNode newNode=new DNode(value,key);
        newNode.prev=end;
        end.next=newNode;
        end=end.next;
        map.put(key,newNode);
    }

    public void put(int key, int value) {
        if(!map.containsKey(key) && map.size()>=size){
            DNode curr=front.next;
            if(size==1){
                front=front.next;
                front.prev=null;
            }
            else{
                DNode next=curr.next;
                next.prev=front;
                front.next=next;
            }
            map.remove(curr.key);
        }

        addNode(key,value);
    }
}

class DNode{
    int val;
    int key;
    DNode next;
    DNode prev;
    public DNode(){

    }
    public DNode(int val,int key){
        this.val=val;
        this.key=key;
    }
}
