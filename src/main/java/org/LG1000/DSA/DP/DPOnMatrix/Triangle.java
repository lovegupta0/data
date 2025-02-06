package org.LG1000.DSA.DP.DPOnMatrix;
import java.util.*;

//120. Triangle
//https://leetcode.com/problems/triangle/description/
public class Triangle {

    //Approach1
    //Recurrsion + Memonization
    class Approach1{
        private int get(List<List<Integer>> triangle,int i,int j,int[][] dp){
            if(i==triangle.size()) return 0;
            if(dp[i][j]!=-1) return dp[i][j];
            int temp=triangle.get(i).get(j)+get(triangle,i+1,j,dp);
            if(triangle.get(i).size()>j+1){
                temp=Math.min(temp,triangle.get(i).get(j+1)+get(triangle,i+1,j+1,dp));
            }
            return dp[i][j]=temp;
        }
        public int minimumTotal(List<List<Integer>> triangle) {
            int[][] dp=new int[triangle.size()+1][triangle.size()+1];
            for(int i=0;i<=triangle.size();i++){
                Arrays.fill(dp[i],-1);
            }
            return get(triangle,0,0,dp);
        }
    }

    //Approach2
    class Approach2{
        private int get(List<List<Integer>> triangle,int n,int m,int[][] dp){
            if(n==0) return 0;
            if(m>triangle.get(n-1).size() || m<=0) return 1000000;

            if(dp[n][m]!=-1) return dp[n][m];

            int t1=triangle.get(n-1).get(m-1)+get(triangle,n-1,m-1,dp);
            int t2=0;
            if(triangle.size()==n){
                t2=Math.min(triangle.get(n-1).get(m-1)+get(triangle,n-1,m,dp),get(triangle,n,m-1,dp));
            }
            else{
                t2=triangle.get(n-1).get(m-1)+get(triangle,n-1,m,dp);
            }

            return dp[n][m]= Math.min(t1,t2);
        }
        public int minimumTotal(List<List<Integer>> triangle) {
            int n=triangle.size();
            int m=triangle.get(n-1).size();
            int[][] dp=new int[n+1][m+1];

            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }

            return get(triangle,n,m,dp);

        }
    }

    //Approach3
    //Buttom up
    class Approach3{
        public int minimumTotal(List<List<Integer>> triangle) {
            int n=triangle.size();
            int m=triangle.get(n-1).size();
            int[][] dp=new int[n+1][m+1];
            int min=Integer.MAX_VALUE;
            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],1000000);
            }
            dp[0][0]=0;

            for(int i=1;i<=n;i++){
                for(int j=1;j<=triangle.get(i-1).size();j++){
                    int data=triangle.get(i-1).get(j-1);
                    int t1=dp[i-1][j-1]+data;
                    int t2=dp[i-1][j]+data;
                    dp[i][j]=Math.min(dp[i][j],Math.min(t1,t2));
                }
            }

            for(int i=0;i<=m;i++){
                min=Math.min(min,dp[n][i]);
            }

            return min;
        }
    }
}
