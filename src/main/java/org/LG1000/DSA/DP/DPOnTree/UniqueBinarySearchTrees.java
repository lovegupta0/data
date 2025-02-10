package org.LG1000.DSA.DP.DPOnTree;
import java.util.*;

//96. Unique Binary Search Trees
//https://leetcode.com/problems/unique-binary-search-trees/description/
public class UniqueBinarySearchTrees {

    //Approach1
    //Recursion + memoization
    class Approach1{
        int get(int n,int[] dp){
            if(n==0 || n==1) return 1;
            if(dp[n]!=-1) return dp[n];
            int sum=0;
            for(int i=1;i<=n;i++){
                sum+=(get(i-1,dp)*get(n-i,dp));
            }

            return dp[n]= sum;
        }
        public int numTrees(int n) {
            int[] dp=new int[n+1];
            Arrays.fill(dp,-1);
            return get(n,dp);
        }
    }

    //Approach2
    // Buttom up dp
    class Approach2{
        public int numTrees(int n) {
            int[] dp=new int[n+1];
            dp[0]=1;
            dp[1]=1;
            for(int i=2;i<=n;i++){
                for(int j=1;j<=i;j++){
                    dp[i]+=(dp[j-1]*dp[i-j]);
                }
            }

            return dp[n];
        }
    }
}
