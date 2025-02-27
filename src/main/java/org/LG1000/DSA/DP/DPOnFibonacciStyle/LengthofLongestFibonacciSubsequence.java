package org.LG1000.DSA.DP.DPOnFibonacciStyle;
import java.util.*;

//873. Length of Longest Fibonacci Subsequence
//https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/
public class LengthofLongestFibonacciSubsequence {
    private int get(int[] arr,int i,int j,Map<Integer,Integer> map,int[][] dp){
        if(i==arr.length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int temp=0;
        int val=arr[i]+arr[j];
        if(map.containsKey(val)){
            int next=map.get(val);
            temp=Math.max(temp,1+get(arr,j,next,map,dp));
        }
        return dp[i][j]= temp;

    }
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        int n=arr.length;
        int[][] dp=new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                res=Math.max(get(arr,i,j,map,dp)+2,res);
            }
        }
        return res>2?res:0;
    }
}
