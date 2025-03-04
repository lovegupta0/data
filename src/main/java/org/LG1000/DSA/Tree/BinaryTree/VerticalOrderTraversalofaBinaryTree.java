package org.LG1000.DSA.Tree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;
import java.util.*;

//987. Vertical Order Traversal of a Binary Tree
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
public class VerticalOrderTraversalofaBinaryTree {
    //T.C. -> O(NLOGN) & S.C. -> O(N)
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,PriorityQueue<int[]>> map=new TreeMap<>();
        List<List<Integer>> lst=new ArrayList<>();
        Queue<Data> q=new LinkedList<>();
        int count=0;
        q.add(new Data(root,0));
        while(!q.isEmpty()){
            int t=q.size();
            while(t-- >0){
                Data d=q.poll();
                if(!map.containsKey(d.h)){
                    map.put(d.h,new PriorityQueue<>((a,b)->{
                        if(a[0]==b[0]) return a[1]-b[1];
                        return a[0]-b[0];
                    }));
                }
                map.get(d.h).add(new int[]{count,d.p.val});
                if(d.p.left!=null){
                    q.add(new Data(d.p.left,d.h-1));
                }
                if(d.p.right!=null){
                    q.add(new Data(d.p.right,d.h+1));
                }
            }
            count++;
        }

        for(int key:map.keySet()){
            List<Integer> temp=new ArrayList<>();
            PriorityQueue pq=map.get(key);
            while(!pq.isEmpty()){
                int[] arr= (int[]) pq.poll();
                temp.add(arr[1]);
            }
            lst.add(temp);
        }

        return lst;

    }
}

class Data{
    TreeNode p;
    int h;
    Data(TreeNode p,int h){
        this.p=p;
        this.h=h;
    }
}
