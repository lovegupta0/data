package org.LG1000.DSA.Tree.BinaryTree;
import java.util.*;

//Burning Tree
//https://www.geeksforgeeks.org/problems/burning-tree/1
public class BurningTree {
    static int cost=0;
    private static void makeUndirectedEdge(Map<Integer,List<Integer>> graph,int src,int dest){
        if(!graph.containsKey(src)){
            graph.put(src,new ArrayList<>());
        }

        if(!graph.containsKey(dest)){
            graph.put(dest,new ArrayList<>());
        }

        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }
    private static void get(Map<Integer,List<Integer>> graph,Set<Integer> visited,int src,int k){
        if(!graph.containsKey(src) || visited.contains(src)) return;
        visited.add(src);
        cost=Math.max(cost,k);
        for(int dest:graph.get(src)){
            get(graph,visited,dest,k+1);
        }
    }
    public static int minTime(Node root, int target) {
        cost=0;
        Map<Integer,List<Integer>> graph=new HashMap<>();
        Queue<Node> q=new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            Node p=q.poll();
            if(p.left!=null){
                makeUndirectedEdge(graph,p.data,p.left.data);
                q.add(p.left);
            }
            if(p.right!=null){
                makeUndirectedEdge(graph,p.data,p.right.data);
                q.add(p.right);
            }
        }

        get(graph,new HashSet<>(),target,0);

        return cost;
    }
}
