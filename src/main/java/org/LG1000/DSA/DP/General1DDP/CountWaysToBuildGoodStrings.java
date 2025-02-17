package org.LG1000.DSA.DP.General1DDP;
import java.util.*;

//2466. Count Ways To Build Good Strings
//https://leetcode.com/problems/count-ways-to-build-good-strings/description/
public class CountWaysToBuildGoodStrings {
    //Approach1
    //Recursion + Memoization
    class Approach1{
        int m=1000000007;
        private int get(int low, int high, int zero, int one,int size,int[] dp){
            if(size>high) return 0;
            if(dp[size]!=-1) return dp[size];
            int temp=0;
            if(size>=low && size<=high) temp++;
            temp=(temp%m+get(low,high,zero,one,size+zero,dp)%m)%m;
            temp=(temp%m+get(low,high,zero,one,size+one,dp)%m)%m;

            return dp[size]= temp;

        }
        public int countGoodStrings(int low, int high, int zero, int one) {
            int[] dp=new int[high+1];
            Arrays.fill(dp,-1);

            return get(low,high,zero,one,0,dp);
        }
    }
}
