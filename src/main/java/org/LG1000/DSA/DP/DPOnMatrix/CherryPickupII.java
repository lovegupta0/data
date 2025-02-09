package org.LG1000.DSA.DP.DPOnMatrix;
import java.util.*;

//1463. Cherry Pickup II
//https://leetcode.com/problems/cherry-pickup-ii/description/
public class CherryPickupII {

    //Approach1
    //Recursion + Memoization
    class Approach1{

        //Sudo
        /*
         It is same as cherry pickup only change in combination:
            a. i1+1,j1,i2+1,j2-1
            b. i1+1,j1,i2+1,j2
            c. i1+1,j1,i2+1,j2+1
            d. i1+1,j1+1,i2+1,j2-1
            e. i1+1,j1+1,i2+1,j2
            f. i1+1,j1+1,i2+1,j2+1
            g. i1+1,j1-1,i2+1,j2-1
            h. i1+1,j1-1,i2+1,j2
            i. i1+1,j1-1,i2+1,j2+

         Here the parameters are i1,j1 & i2,j2
         Do we need 4 params, ans is no
         we observe that i1 & i2 is increasing by 1 all the time and starting point is always 0
         we can do it as int get(int[][] grid,int n,int m,int i,int j1,int j2)

        */
        private int get(int[][] grid,int n,int m,int i1,int j1,int i2,int j2,int[][][][] dp){
            if(i1<0 || i2<0 || i1>=n || i2>=n || j1<0 || j2<0 || j1>=m || j2>=m) return 0;
            if(i1==n-1 && i2==n-1){
                if(j1==j2) return grid[i1][j1];
                else return grid[i1][j1]+grid[i2][j2];
            }
            if(dp[i1][j1][i2][j2]!=-1) return dp[i1][j1][i2][j2];
            int v1=0;
            int v2=0;
            if(i1==i2 && j1==j2){
                v1=grid[i1][j1];
            }
            else{
                v1=grid[i1][j1];
                v2=grid[i2][j2];
            }

            grid[i1][j1]=0;
            grid[i2][j2]=0;

            int t1=get(grid,n,m,i1+1,j1,i2+1,j2-1,dp);
            int t2=get(grid,n,m,i1+1,j1,i2+1,j2,dp);
            int t3=get(grid,n,m,i1+1,j1,i2+1,j2+1,dp);
            int t4=get(grid,n,m,i1+1,j1+1,i2+1,j2-1,dp);
            int t5=get(grid,n,m,i1+1,j1+1,i2+1,j2,dp);
            int t6=get(grid,n,m,i1+1,j1+1,i2+1,j2+1,dp);
            int t7=get(grid,n,m,i1+1,j1-1,i2+1,j2-1,dp);
            int t8=get(grid,n,m,i1+1,j1-1,i2+1,j2,dp);
            int t9=get(grid,n,m,i1+1,j1-1,i2+1,j2+1,dp);

            grid[i2][j2]=v2;
            grid[i1][j1]=v1;

            int temp=Math.max(Math.max(Math.max(t1,t2),Math.max(t3,t4)),Math.max(Math.max(t5,t6),Math.max(t7,t8)));
            return dp[i1][j1][i2][j2]= v1+v2+ Math.max(temp,t9);
        }
        public int cherryPickup(int[][] grid) {
            int n=grid.length;
            int m=grid[0].length;
            int[][][][] dp=new int[n+1][m+1][n+1][m+1];

            for(int i=0;i<=n;i++){
                for(int j=0;j<=m;j++){
                    for(int k=0;k<=n;k++){
                        Arrays.fill(dp[i][j][k],-1);
                    }
                }
            }

            return get(grid,n,m,0,0,0,m-1,dp);
        }
    }

    //Approach2
    // Recursion + Memoization
    // space optimisation O(n^3)

    class Apprach2{
        private int get(int[][] grid,int n,int m,int i,int j1,int j2,int[][][] dp){
            if(i<0 || i>=n || j1<0 || j2<0 || j1>=m || j2>=m) return 0;
            if(i==n-1){
                if(j1==j2) return grid[i][j1];
                else return grid[i][j1]+grid[i][j2];
            }
            if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
            int v1=0;
            int v2=0;
            if(j1==j2){
                v1=grid[i][j1];
            }
            else{
                v1=grid[i][j1];
                v2=grid[i][j2];
            }

            grid[i][j1]=0;
            grid[i][j2]=0;

            int t1=get(grid,n,m,i+1,j1,j2-1,dp);
            int t2=get(grid,n,m,i+1,j1,j2,dp);
            int t3=get(grid,n,m,i+1,j1,j2+1,dp);
            int t4=get(grid,n,m,i+1,j1+1,j2-1,dp);
            int t5=get(grid,n,m,i+1,j1+1,j2,dp);
            int t6=get(grid,n,m,i+1,j1+1,j2+1,dp);
            int t7=get(grid,n,m,i+1,j1-1,j2-1,dp);
            int t8=get(grid,n,m,i+1,j1-1,j2,dp);
            int t9=get(grid,n,m,i+1,j1-1,j2+1,dp);

            grid[i][j2]=v2;
            grid[i][j1]=v1;

            int temp=Math.max(Math.max(Math.max(t1,t2),Math.max(t3,t4)),Math.max(Math.max(t5,t6),Math.max(t7,t8)));
            return dp[i][j1][j2]= v1+v2+ Math.max(temp,t9);
        }
        public int cherryPickup(int[][] grid) {
            int n=grid.length;
            int m=grid[0].length;
            int[][][] dp=new int[n+1][m+1][m+1];

            for(int i=0;i<=n;i++){
                for(int j=0;j<=m;j++){
                    Arrays.fill(dp[i][j],-1);
                }
            }

            return get(grid,n,m,0,0,m-1,dp);
        }
    }
}
