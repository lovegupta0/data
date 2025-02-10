package org.LG1000.DSA.DP.DPOnTree;
import java.util.*;

//337. House Robber III
//https://leetcode.com/problems/house-robber-iii/description/
public class HouseRobberIII {
    //Approach1
    //Recursion + Memoization
    class Approach1{
        private int get(TreeNode root,int stolen,Map<TreeNode,Map<Integer,Integer>> dp){
            if(root==null) return 0;
            if(dp.containsKey(root) && dp.get(root).containsKey(stolen)) return dp.get(root).get(stolen);
            int temp=0;
            if(stolen==1){
                int l=get(root.left,0,dp);
                int r=get(root.right,0,dp);
                temp=Math.max(temp,l+r);
            }
            else{
                int l1=get(root.left,0,dp);
                int r1=get(root.right,0,dp);

                int l2=get(root.left,1,dp);
                int r2=get(root.right,1,dp);

                temp=Math.max(temp,Math.max(l1+r1,root.val+l2+r2));
            }
            Map<Integer,Integer> map=new HashMap<>();
            map.put(stolen,temp);
            dp.put(root,map);
            return temp;
        }
        public int rob(TreeNode root) {
            Map<TreeNode,Map<Integer,Integer>> dp=new HashMap<>();
            return get(root,0,dp);
        }
    }
}
