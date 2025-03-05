package org.LG1000.DSA.Tree.BinaryTree;
import org.LG1000.DSA.Tree.TreeNode;
import java.util.*;

//863. All Nodes Distance K in Binary Tree
//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
public class AllNodesDistanceKinBinaryTree {
    private void makeUndirectedEdge(Map<Integer,List<Integer>> graph,int src,int dest){
        if(!graph.containsKey(src)){
            graph.put(src,new ArrayList<>());
        }

        if(!graph.containsKey(dest)){
            graph.put(dest,new ArrayList<>());
        }

        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }
    private void get(Map<Integer,List<Integer>> graph,Set<Integer> visited,int src,int k, List<Integer> lst){
        if(!graph.containsKey(src) || visited.contains(src) || k<0) return;
        if(k==0) lst.add(src);
        visited.add(src);
        for(int dest:graph.get(src)){
            get(graph,visited,dest,k-1,lst);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> lst=new ArrayList<>();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode p=q.poll();
            if(p.left!=null){
                makeUndirectedEdge(graph,p.val,p.left.val);
                q.add(p.left);
            }
            if(p.right!=null){
                makeUndirectedEdge(graph,p.val,p.right.val);
                q.add(p.right);
            }
        }

        get(graph,new HashSet<>(),target.val,k,lst);

        return lst;
    }
}
