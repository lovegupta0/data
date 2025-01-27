package org.LG1000.DSA.DP.DPOnFibonacciStyle;
import java.util.*;

//746. Min Cost Climbing Stairs
//https://leetcode.com/problems/min-cost-climbing-stairs/description/

public class MinCostClimbingStairs {

    //Approach1
    //Recurrsion + memonization
    class Approach1{
        private int get(int[] cost,int n,int[] dp){
            if(n<=1) return 0;
            if(dp[n]!=-1) return dp[n];
            int t1=cost[n-1] +get(cost,n-1,dp);
            if(n>1){
                t1=Math.min(t1,cost[n-2]+get(cost,n-2,dp));
            }
            return dp[n]= t1;
        }
        public int minCostClimbingStairs(int[] cost) {
            int n=cost.length;
            int[] dp=new int[n+1];
            Arrays.fill(dp,-1);

            return get(cost,n,dp);

        }
    }

    //Approach2
    //Buttom up dp
    class Approach2{
        public int minCostClimbingStairs(int[] cost) {
            int n=cost.length;
            int[] dp=new int[n+1];

            for(int i=0;i<=n;i++){
                if(i==0 || i==1) dp[i]=0;
                else{
                    dp[i]=Math.min(cost[i-1]+dp[i-1],cost[i-2]+dp[i-2]);
                }
            }


            return dp[n];

        }
    }
}
