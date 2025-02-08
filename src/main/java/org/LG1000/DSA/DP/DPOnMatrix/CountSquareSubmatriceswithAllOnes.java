package org.LG1000.DSA.DP.DPOnMatrix;
import java.util.*;

//1277. Count Square Submatrices with All Ones
//https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
public class CountSquareSubmatriceswithAllOnes {
    //Approach1
    //Recurssion + memonization
    class Approach1{
        private int get(int[][] matrix,int n,int m,int[][] dp){
            if(n==0 || m==0 || matrix[n-1][m-1]==0) return 0;

            if(dp[n][m]!=-1) return dp[n][m];

            int top=get(matrix,n-1,m,dp);
            int left=get(matrix,n,m-1,dp);
            int diagnol=get(matrix,n-1,m-1,dp);

            return dp[n][m]= 1+Math.min(top,Math.min(left,diagnol));
        }
        public int countSquares(int[][] matrix) {
            int n=matrix.length;
            int m=matrix[0].length;
            int total=0;
            int[][] dp=new int[n+1][m+1];

            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }

            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    total+=get(matrix,i,j,dp);
                }
            }


            return total;
        }
    }

    //Approach2
    //Buttom up from above
    class Approach2{
        public int countSquares(int[][] matrix) {
            int n=matrix.length;
            int m=matrix[0].length;
            int total=0;
            int[][] dp=new int[n+1][m+1];

            for(int i=0;i<=n;i++){
                for(int j=0;j<=m;j++){
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }
                    else if(matrix[i-1][j-1]==1){
                        int t1=dp[i-1][j];
                        int t2=dp[i][j-1];
                        int t3=dp[i-1][j-1];
                        dp[i][j]=1+Math.min(t1,Math.min(t2,t3));
                    }
                    total+=dp[i][j];
                }
            }


            return total;
        }
    }
}
