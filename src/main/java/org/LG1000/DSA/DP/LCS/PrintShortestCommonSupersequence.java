package org.LG1000.DSA.DP.LCS;

//1092. Shortest Common Supersequence
//https://leetcode.com/problems/shortest-common-supersequence/description/

public class PrintShortestCommonSupersequence {
    //Approach 1-Memeory Limit Exceeded
    //Recursion + Memonization
    class Approach1{
        private String get(String s1,String s2, int n,int m,int i,int j, String dp[][]){
            if(i==n && j==m) return "";
            if(i==n) return s2.substring(j);
            if(j==m) return s1.substring(i);
            if(dp[i][j]!=null) return dp[i][j];
            if(i<n && j<m && s1.charAt(i)==s2.charAt(j)){
                return dp[i][j]=s1.charAt(i)+get(s1,s2,n,m,i+1,j+1,dp);
            }
            String temp1="";
            String temp2="";
            if(i<n){
                temp1=s1.charAt(i)+get(s1,s2,n,m,i+1,j,dp);
            }
            if(j<m){
                temp2=s2.charAt(j)+get(s1,s2,n,m,i,j+1,dp);
            }
            return dp[i][j]= temp1.length()<temp2.length()?temp1:temp2;
        }
        public String shortestCommonSupersequence(String str1, String str2) {
            int n=str1.length();
            int m=str2.length();
            String[][] dp=new String[n+1][m+1];
            return get(str1,str2,n,m,0,0,dp);
        }
    }

    //Approach 2
    //Buttom up from ShortestCommonSupersequence

    class Approach2{
        public String shortestCommonSupersequence(String str1, String str2) {
            int n=str1.length();
            int m=str2.length();
            String s="";
            int[][] dp=new int[n+1][m+1];

            //initialization
            for(int i=0;i<=n;i++){
                dp[i][0]=i;
            }
            for(int j=0;j<=m;j++){
                dp[0][j]=j;
            }

            //Buttom up dp calculation
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(str1.charAt(i-1)==str2.charAt(j-1)){
                        dp[i][j]=1+dp[i-1][j-1];
                    }
                    else{
                        dp[i][j]=1+Math.min(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }

            //Collecting result from buttom up matrix
            while(n>0 && m>0){
                if(str1.charAt(n-1)==str2.charAt(m-1)){
                    s=str1.charAt(n-1)+s;
                    n--;
                    m--;
                }
                else if(dp[n-1][m]<dp[n][m-1]){
                    s=str1.charAt(n-1)+s;
                    n--;
                }
                else{
                    s=str2.charAt(m-1)+s;
                    m--;
                }
            }

            if(m>0){
                s=str2.substring(0,m)+s;
            }
            else{
                s=str1.substring(0,n)+s;
            }

            return s;
        }
    }
}
