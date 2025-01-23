package org.LG1000.DSA.DP.LCS;
import java.util.*;

//44. Wildcard Matching
//https://leetcode.com/problems/wildcard-matching/description/
public class WildcardMatching {

    //Approach1
    //Recursion + memonization
    class Approach1{
        private boolean isAllStar(String s){
            return s.replace("*","").length()==0;
        }
        private boolean get(String s,String p,int n,int m,int[][] dp){
            if(n==0 && m==0) return true;
            if(n==0 && isAllStar(p.substring(0,m))) return true;
            if(n==0 || m==0) return false;

            if(dp[n][m]!=-1) return dp[n][m]==0?false:true;

            if(s.charAt(n-1)==p.charAt(m-1) || p.charAt(m-1)=='?'){
                boolean res= get(s,p,n-1,m-1,dp);
                dp[n][m]= res?1:0;
                return res;
            }
            boolean temp=false;
            if(p.charAt(m-1)=='*'){
                temp= temp | get(s,p,n-1,m,dp) | get(s,p,n,m-1,dp);
            }
            dp[n][m]=temp?1:0;
            return temp;
        }
        public boolean isMatch(String s, String p) {
            int n=s.length();
            int m=p.length();
            int[][] dp=new int[n+1][m+1];

            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }
            return get(s,p,n,m,dp);

        }
    }

    //Approach2
    //Buttom up approach --> converted from above
    class Approach2{
        private boolean isAllStar(String s){
            return s.replace("*","").length()==0;
        }

        public boolean isMatch(String s, String p) {
            int n=s.length();
            int m=p.length();
            boolean[][] dp=new boolean[n+1][m+1];

            for(int i=0;i<=n;i++){
                for(int j=0;j<=m;j++){
                    if(i==0 && j==0){
                        dp[i][j]=true;
                    }
                    else if(i==0 && isAllStar(p.substring(0,j))){
                        dp[i][j]=true;
                    }
                    else if(i==0 || j==0){
                        dp[i][j]=false;
                    }
                    else if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                        dp[i][j]=dp[i-1][j-1];
                    }
                    else if(p.charAt(j-1)=='*'){
                        dp[i][j]=dp[i-1][j] | dp[i][j-1];
                    }
                }
            }
            return dp[n][m];

        }
    }
}
