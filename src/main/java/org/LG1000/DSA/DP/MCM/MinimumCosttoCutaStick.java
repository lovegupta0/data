package org.LG1000.DSA.DP.MCM;
import java.util.*;

//1547. Minimum Cost to Cut a Stick
//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
public class MinimumCosttoCutaStick {
    //Approach1
    //Recursion + Memoization
    class Approach1{
        private int get(int ss,int se,int[] cuts,int i,int j,int[][] dp){
            if(i>j) return 0;
            if(dp[i][j]!=-1) return dp[i][j];
            int mn=Integer.MAX_VALUE;

            for(int k=i;k<=j;k++){
                int temp=get(ss,cuts[k],cuts,i,k-1,dp)+get(cuts[k],se,cuts,k+1,j,dp)+se-ss;
                mn=Math.min(mn,temp);
            }

            return dp[i][j]= mn;
        }
        public int minCost(int n, int[] cuts) {
            Arrays.sort(cuts);
            int m=cuts.length;

            int[][] dp=new int[m+1][m+1];
            for(int i=0;i<=m;i++){
                Arrays.fill(dp[i],-1);
            }

            return get(0,n,cuts,0,m-1,dp);
        }
    }
}
