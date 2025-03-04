package org.LG1000.DSA.Tree.BinaryTree;
import java.util.*;

//Top View of Binary Tree
//https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
public class TopViewofBinaryTree {

    public ArrayList<Integer> topView(Node root) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        ArrayList<Integer> lst=new ArrayList<>();
        Queue<Data> q=new LinkedList<>();
        q.add(new Data(0,root));

        while(!q.isEmpty()){
            Data d=q.poll();
            if(!map.containsKey(d.h)) map.put(d.h,d.p.data);
            if(d.p.left!=null){
                q.add(new Data(d.h-1,d.p.left));
            }
            if(d.p.right!=null){
                q.add(new Data(d.h+1,d.p.right));
            }
        }

        for(int key:map.keySet()){
            lst.add(map.get(key));
        }

        return lst;
    }

    class Data{
        Node p;
        int h;
        Data(int h,Node p){
            this.h=h;
            this.p=p;
        }
    }
}
