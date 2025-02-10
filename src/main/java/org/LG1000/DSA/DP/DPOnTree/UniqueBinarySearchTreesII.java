package org.LG1000.DSA.DP.DPOnTree;
import java.util.*;

//95. Unique Binary Search Trees II
//https://leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBinarySearchTreesII {
    //Approach1
    //Recursion
    // TC --> N * (4^N/N^1.5)
    class Approch1{
        private List<TreeNode> get(int i,int n){
            List<TreeNode> lst=new ArrayList<>();
            if(i>n){
                lst.add(null);
                return lst;
            }
            if(i==n){
                lst.add(new TreeNode(i));
                return lst;
            }
            for(int k=i;k<=n;k++){
                List<TreeNode> left=get(i,k-1);
                List<TreeNode> right=get(k+1,n);
                for(TreeNode l:left){
                    for(TreeNode r:right){
                        TreeNode root=new TreeNode(k);
                        root.left=l;
                        root.right=r;
                        lst.add(root);
                    }
                }
            }
            return lst;
        }
        public List<TreeNode> generateTrees(int n) {
            return get(1,n);
        }
    }

    //Approach2
    //Recursion + Memoization
    // Use HashMap to Memoization with start+end i.e. i & n
}
