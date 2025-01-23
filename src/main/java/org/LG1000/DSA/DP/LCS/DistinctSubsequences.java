package org.LG1000.DSA.DP.LCS;
import java.util.*;

//115. Distinct Subsequences
//https://leetcode.com/problems/distinct-subsequences/description/
public class DistinctSubsequences {
    //Approach1
    //Recurrsion + Memonization
    class Approach1{
        private int get(String s, String t,int n,int m,int[][] dp){
            if(m==0) return 1;
            if(n==0) return 0;
            if(dp[n][m]!=-1) return dp[n][m];
            int temp=0;
            if(s.charAt(n-1)==t.charAt(m-1)){
                temp+=get(s,t,n-1,m-1,dp);
            }
            temp+=get(s,t,n-1,m,dp);
            return dp[n][m]= temp;
        }
        public int numDistinct(String s, String t) {
            int n=s.length();
            int m=t.length();
            int[][] dp=new int[n+1][m+1];
            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }
            return get(s,t,n,m,dp);
        }
    }

    //Approach2
    //Buttom up --> converting from above to buttom up dp
    class Approach2{
        public int numDistinct(String s, String t) {
            int n=s.length();
            int m=t.length();
            int[][] dp=new int[n+1][m+1];

            //base condition i.e initializaion
            for(int i=0;i<=n;i++){
                dp[i][0]=1;
            }

            //calculation
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(s.charAt(i-1)==t.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                    }
                    else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }

            return dp[n][m];
        }
    }
}
