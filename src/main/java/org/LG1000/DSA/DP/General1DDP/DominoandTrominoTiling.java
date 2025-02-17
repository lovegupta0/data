package org.LG1000.DSA.DP.General1DDP;
import java.util.*;

//790. Domino and Tromino Tiling
//https://leetcode.com/problems/domino-and-tromino-tiling/description/
public class DominoandTrominoTiling {
    //Approach1
    //Recursion + Memoization
    class Approach1{
        int m=1000000007;
        private int get(int n,int[] dp){
            if(n<=0) return 0;
            if(n==1) return 1;
            if(n==2) return 2;
            if(n==3) return 5;

            if(dp[n]!=-1) return dp[n];

            return dp[n]= ((get(n-1,dp)*2)%m+get(n-3,dp)%m)%m;
        }
        public int numTilings(int n) {
            int[] dp=new int[n+1];
            Arrays.fill(dp,-1);

            return get(n,dp);
        }
    }
}
