package org.LG1000.DSA.DP.LCS;
import java.util.*;

//72. Edit Distance
//https://leetcode.com/problems/edit-distance/description/
public class EditDistance {
    //Approach1
    //Recurrsion + Memonization

    class Approach1{
        private int get(String s1,String s2,int n,int m,int[][] dp){
            if(n==0 && m==0) return 0;
            if(n==0 || m==0) return n+m;
            if(dp[n][m]!=-1) return dp[n][m];
            if(s1.charAt(n-1)==s2.charAt(m-1)){
                return get(s1,s2,n-1,m-1,dp);
            }

            //insertion
            int t1=1+get(s1,s2,n,m-1,dp);
            //deletion
            int t2=1+get(s1,s2,n-1,m,dp);
            //replace
            int t3=1+get(s1,s2,n-1,m-1,dp);

            return dp[n][m]= Math.min(t1,Math.min(t2,t3));
        }


        public int minDistance(String word1, String word2) {
            int n=word1.length();
            int m=word2.length();
            int[][] dp=new int[n+1][m+1];
            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }

            return get(word1,word2,n,m,dp);
        }
    }

    //Approach2
    //Buttom up --> derived from above
    class Approach2{
        public int minDistance(String word1, String word2) {
            int n=word1.length();
            int m=word2.length();
            int[][] dp=new int[n+1][m+1];


            for(int i=0;i<=n;i++){
                for(int j=0;j<=m;j++){
                    if(i==0 && j==0){
                        dp[i][j]=0;
                    }
                    else if(i==0 || j==0){
                        dp[i][j]=i+j;
                    }
                    else if(word1.charAt(i-1)==word2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1];
                    }
                    else{
                        int t1=1+dp[i][j-1];
                        int t2=1+dp[i-1][j];
                        int t3=1+dp[i-1][j-1];
                        dp[i][j]=Math.min(t1,Math.min(t2,t3));
                    }
                }
            }

            return dp[n][m];


        }
    }
}
