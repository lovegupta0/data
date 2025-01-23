package org.LG1000.DSA.DP.LCS;
import java.util.*;

//1035. Uncrossed Lines
//https://leetcode.com/problems/uncrossed-lines/description/

public class UncrossedLines {

    //Approach1
    //Recurrsion + Memonization
    class Approach1{
        private int get(int[] nums1, int[] nums2,int n,int m,int[][] dp){
            if(n==0 || m==0) return 0;

            if(dp[n][m]!=-1) return dp[n][m];

            if(nums1[n-1]==nums2[m-1]){
                return dp[n][m]= 1+get(nums1,nums2,n-1,m-1,dp);
            }

            int t1=get(nums1,nums2,n-1,m,dp);
            int t2=get(nums1,nums2,n,m-1,dp);
            return dp[n][m]= Math.max(t1,t2);
        }
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int n=nums1.length;
            int m=nums2.length;
            int[][] dp=new int[n+1][m+1];

            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }

            return get(nums1,nums2,n,m,dp);
        }
    }

    //Approach2
    //Bottom up dp --> from above
    class Approach2{
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int n=nums1.length;
            int m=nums2.length;
            int[][] dp=new int[n+1][m+1];

            for(int i=0;i<=n;i++){
                for(int j=0;j<=m;j++){
                    if(j==0 || i==0){
                        dp[i][j]=0;
                    }
                    else if(nums1[i-1]==nums2[j-1]){
                        dp[i][j]=1+dp[i-1][j-1];
                    }
                    else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }

            return dp[n][m];
        }
    }
}
