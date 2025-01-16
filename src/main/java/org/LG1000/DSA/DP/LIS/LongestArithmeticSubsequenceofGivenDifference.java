package org.LG1000.DSA.DP.LIS;
import java.util.*;

//1218
//https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/

public class LongestArithmeticSubsequenceofGivenDifference {
    //TLE
    public int longestSubsequenceTLE(int[] arr, int difference) {
        int mx=1;
        int[] dp=new int[arr.length];
        Arrays.fill(dp,1);

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if((arr[i]-arr[j])==difference){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    mx=Math.max(mx,dp[i]);
                }
            }
        }

        return mx;
    }

    // working
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map=new HashMap<>();
        int mx=1;
        for(int i=0;i<arr.length;i++){
            int prev=arr[i]-difference;
            map.put(arr[i],map.getOrDefault(prev,0)+1);
            mx=Math.max(mx,map.get(arr[i]));

        }

        return mx;
    }
}
