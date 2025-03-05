package org.LG1000.DSA.Tree.BinaryTree;
import java.util.*;

//Root to Leaf Paths
//https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
public class RoottoLeafPaths {
    private static void get(Node root,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> res){
        if(root==null) return;
        temp.add(root.data);
        if(root.left==null && root.right==null) res.add(new ArrayList<>(temp));
        get(root.left,new ArrayList<>(temp),res);
        get(root.right,new ArrayList<>(temp),res);
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        get(root,new ArrayList<>(),res);

        return res;
    }
}
