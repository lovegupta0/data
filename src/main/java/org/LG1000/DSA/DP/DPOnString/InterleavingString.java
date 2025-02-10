package org.LG1000.DSA.DP.DPOnString;
import java.util.*;

//97. Interleaving String
//https://leetcode.com/problems/interleaving-string/description/
public class InterleavingString {

    //Approach1
    //Recursion + memoization
    class Approach1{
        public boolean get(String s1,String s2,String s3,int n,int m,int k,int[][][] dp){
            if(n==0 && m==0 && k==0) return true;
            if(dp[n][m][k]!=-1) return dp[n][m][k]==1?true:false;
            boolean temp=false;
            if(n>0 && k>0 && s1.charAt(n-1)==s3.charAt(k-1)){
                temp= temp | get(s1,s2,s3,n-1,m,k-1,dp);
            }
            if(m>0 && k>0 && s2.charAt(m-1)==s3.charAt(k-1)){
                temp= temp | get(s1,s2,s3,n,m-1,k-1,dp);
            }
            dp[n][m][k]=temp?1:0;
            return temp;

        }
        public boolean isInterleave(String s1, String s2, String s3) {
            int n=s1.length();
            int m=s2.length();
            int k=s3.length();

            int[][][] dp=new int[n+1][m+1][k+1];

            for(int i=0;i<=n;i++){
                for(int j=0;j<=m;j++){
                    Arrays.fill(dp[i][j],-1);
                }
            }


            return get(s1,s2,s3,n,m,k,dp);


        }
    }

    //Approach2
    // Buttom up dp
    class Approach2{
        public boolean isInterleave(String s1, String s2, String s3) {
            int n=s1.length();
            int m=s2.length();
            int k=s3.length();

            if(n+m!=k) return false;

            boolean[][] dp=new boolean[n+1][m+1];

            for(int i=0;i<=n;i++){
                for(int j=0;j<=m;j++){
                    if(i==0 && j==0){
                        dp[i][j]=true;
                    }
                    else{
                        boolean temp=false;
                        if(i>0 && s1.charAt(i-1)==s3.charAt(i+j-1)){
                            temp=temp | dp[i-1][j];
                        }
                        if(j>0 && s2.charAt(j-1)==s3.charAt(i+j-1) ){
                            temp=temp | dp[i][j-1];
                        }
                        dp[i][j]=temp;
                    }
                }
            }


            return dp[n][m];


        }
    }
}
