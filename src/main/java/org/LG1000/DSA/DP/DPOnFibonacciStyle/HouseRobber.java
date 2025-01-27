package org.LG1000.DSA.DP.DPOnFibonacciStyle;
import java.util.*;

//198. House Robber
//https://leetcode.com/problems/house-robber/description/
public class HouseRobber {

    //Approach1
    //Recurrsion + Memonization
    class Approach1{
        private int get(int[] nums,int n,int[] dp){
            if(n<=0) return 0;
            if(dp[n]!=-1) return dp[n];

            int t1=nums[n-1] +get(nums,n-2,dp);
            int t2=get(nums,n-1,dp);

            return dp[n]= Math.max(t1,t2);
        }
        public int rob(int[] nums) {
            int n=nums.length;
            int[] dp=new int[n+1];
            Arrays.fill(dp,-1);

            return get(nums,n,dp);
        }
    }

    //Approach2
    //Recurrsion + memonization
    class Approach2{
        public int rob(int[] nums) {
            int n=nums.length;
            int[] dp=new int[n+1];

            for(int i=0;i<=n;i++){
                if(i==0) dp[i]=0;
                else if(i==1) dp[i]=nums[i-1];
                else{
                    dp[i]=Math.max(dp[i-1],nums[i-1]+dp[i-2]);
                }
            }

            return dp[n];
        }
    }
}
