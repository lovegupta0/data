package org.LG1000.DSA.DP.DPOnFibonacciStyle;
import java.util.*;

//70. Climbing Stairs
//https://leetcode.com/problems/climbing-stairs/description/
public class ClimbingStairs {

    //Approach1
    // Recurrsion + memonization
    class Approach1{
        private int get(int n,int[] dp){
            if(n==0 || n==1) return 1;
            if(dp[n]!=-1) return dp[n];
            return dp[n]=get(n-1,dp)+get(n-2,dp);
        }
        public int climbStairs(int n) {
            int[] dp=new int[n+1];
            Arrays.fill(dp,-1);
            return get(n,dp);
        }
    }

    //Approach2
    //Buttom up approach from above
    class Approach2{
        public int climbStairs(int n) {
            int[] dp=new int[n+1];

            for(int i=0;i<=n;i++){
                if(i==0) dp[i]=1;
                else if(i==1) dp[i]=1;
                else{
                    dp[i]=dp[i-1]+dp[i-2];
                }
            }

            return dp[n];
        }
    }
}
