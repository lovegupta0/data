package org.LG1000.DSA.DP.MCM;
import java.util.*;

//1043. Partition Array for Maximum Sum
//https://leetcode.com/problems/partition-array-for-maximum-sum/description/
public class PartitionArrayforMaximumSum {
    //Approach1
    //Recursion + Memoization
    class Approach1{
        private int get(int arr[],int k,int i,int[] dp){
            if(i==arr.length) return 0;

            if(dp[i]!=-1) return dp[i];

            int temp=0;
            int val=0;
            for(int j=0;j<k && j+i<arr.length;j++ ){
                val=Math.max(arr[i+j],val);
                temp=Math.max(val*(j+1)+get(arr,k,i+j+1,dp),temp);
            }

            return dp[i]= temp;
        }
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n=arr.length;
            int[] dp=new int[n+1];

            Arrays.fill(dp,-1);

            return get(arr,k,0,dp);
        }
    }
}
