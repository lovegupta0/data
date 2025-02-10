package org.LG1000.DSA.DP.DPOnFibonacciStyle;
import java.util.*;

//213. House Robber II
//https://leetcode.com/problems/house-robber-ii/description/
public class HouseRobberII {

    //Approach1
    //Recursion + Memoization
    // TC --> 2^N & SC --> N
    class Approach1{
        private int get(int[] nums,int i,int n,int flag, int[][] dp){
            if(i>=n) return 0;

            if(dp[i][flag]!=-1) return dp[i][flag];
            int temp=0;
            temp=Math.max(temp,get(nums,i+1,n,flag,dp));
            if(i==n-1 && flag==0){
                temp=Math.max(nums[i]+get(nums,i+2,n,flag,dp),temp);
            }
            else if(i==0){
                temp=Math.max(nums[i]+get(nums,i+2,n,1,dp),temp);
            }
            else if(i<n-1){
                temp=Math.max(nums[i]+get(nums,i+2,n,flag,dp),temp);
            }

            return dp[i][flag]= temp;
        }
        public int rob(int[] nums) {
            int n=nums.length;
            int[][] dp=new int[n+1][2];

            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }

            return get(nums,0,n,0,dp);
        }
    }
}
