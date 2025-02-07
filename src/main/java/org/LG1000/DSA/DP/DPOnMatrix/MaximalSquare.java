package org.LG1000.DSA.DP.DPOnMatrix;
import java.util.*;

//221. Maximal Square
//https://leetcode.com/problems/maximal-square/description/
public class MaximalSquare {

    //Approach1
    //Recurssion + memonization
    class Approach1{
        int max;
        private int get(char[][] matrix,int n,int m,int[][] dp){
            if(n==0 || m==0) return 0;

            if(dp[n][m]!=-1) return dp[n][m];

            int top=get(matrix,n-1,m,dp);
            int left=get(matrix,n,m-1,dp);
            int diagnol=get(matrix,n-1,m-1,dp);
            if(matrix[n-1][m-1]=='1'){
                int temp=1+Math.min(top,Math.min(left,diagnol));
                max=Math.max(max,temp);
                return dp[n][m]= temp;
            }
            return dp[n][m]= 0;
        }
        public int maximalSquare(char[][] matrix) {
            max=0;
            int n=matrix.length;
            int m=matrix[0].length;

            int[][] dp=new int[n+1][m+1];
            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }

            get(matrix,n,m,dp);
            return max*max;
        }
    }

    //Approach2
    //Buttom up from above
    class Approach2{
        public int maximalSquare(char[][] matrix) {
            int max=0;
            int n=matrix.length;
            int m=matrix[0].length;

            int[][] dp=new int[n+1][m+1];
            for(int i=0;i<=n;i++){
                for(int j=0;j<=m;j++){
                    if(i==0 || j==0) dp[i][j]=0;
                    else if(matrix[i-1][j-1]=='1'){
                        int t1=dp[i-1][j];
                        int t2=dp[i][j-1];
                        int t3=dp[i-1][j-1];
                        int temp=1+Math.min(t1,Math.min(t2,t3));
                        dp[i][j]=temp;
                        max=Math.max(max,temp);
                    }
                    else{
                        dp[i][j]=0;
                    }
                }
            }
            return max*max;
        }
    }
}
