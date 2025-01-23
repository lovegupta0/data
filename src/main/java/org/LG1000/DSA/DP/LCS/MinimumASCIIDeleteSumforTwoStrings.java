package org.LG1000.DSA.DP.LCS;
import java.util.*;

//712. Minimum ASCII Delete Sum for Two Strings
//https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
public class MinimumASCIIDeleteSumforTwoStrings {

    //Approach1
    //Recurrsion + Memonization
    class Approach1{
        private int get(String s1,String s2,int n,int m, int[][] dp){
            if(n==0 || m==0) return 0;

            if(dp[n][m]!=-1) return dp[n][m];

            if(s1.charAt(n-1)==s2.charAt(m-1)){
                int val=s1.charAt(n-1);
                return val+get(s1,s2,n-1,m-1,dp);
            }
            int t1=get(s1,s2,n-1,m,dp);
            int t2=get(s1,s2,n,m-1,dp);

            return dp[n][m]= Math.max(t1,t2);
        }
        public int minimumDeleteSum(String s1, String s2) {
            int n=s1.length();
            int m=s2.length();
            int total=0;
            int[][] dp=new int[n+1][m+1];

            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }

            for(int i=0;i<n;i++){
                int v=s1.charAt(i);
                total+=v;
            }
            for(int i=0;i<m;i++){
                int v=s2.charAt(i);
                total+=v;
            }

            return total- 2*get(s1,s2,n,m,dp);
        }
    }

    //Approach2
    // Buttom up dp from above
    class Approach2{
        public int minimumDeleteSum(String s1, String s2) {
            int n=s1.length();
            int m=s2.length();
            int total=0;
            int[][] dp=new int[n+1][m+1];

            for(int i=0;i<=n;i++){
                for(int j=0;j<=m;j++){
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }
                    else if(s1.charAt(i-1)==s2.charAt(j-1)){
                        int v=s1.charAt(i-1);
                        dp[i][j]=v+dp[i-1][j-1];
                    }
                    else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }

            for(int i=0;i<n;i++){
                int v=s1.charAt(i);
                total+=v;
            }
            for(int i=0;i<m;i++){
                int v=s2.charAt(i);
                total+=v;
            }

            return total- 2*dp[n][m];
        }
    }
}
