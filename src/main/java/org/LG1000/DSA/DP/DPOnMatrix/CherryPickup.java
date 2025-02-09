package org.LG1000.DSA.DP.DPOnMatrix;
import java.util.*;

//741. Cherry Pickup
//https://leetcode.com/problems/cherry-pickup/description/
public class CherryPickup {

    //Approach1
    // Recursion --> TLE
    class Approach1{

        //sudo code
        //1. find up to down
        //2. once it reach its end and create another recurrsion to find down to up at end
        //   maintaining the cherry-picked marked it as zero from up to down and once it is computed
        //   reverse it back.
        public int getLeftUp(int[][] grid,int n,int i,int j){
            if(i==0 && j==0) return grid[i][j];
            if(i<0 || j<0 || grid[i][j]==-1) return Integer.MIN_VALUE;
            int val=grid[i][j];
            grid[i][j]=0;
            int t1=getLeftUp(grid,n,i-1,j);
            int t2=getLeftUp(grid,n,i,j-1);
            grid[i][j]=val;
            return val+Math.max(t1,t2);
        }
        public int getRightDown(int[][] grid,int n,int i,int j){
            if(i==n-1 && j==n-1){
                return getLeftUp(grid,n,i,j);
            }
            if(i>=n || j>=n || grid[i][j]==-1) return Integer.MIN_VALUE;

            int val=grid[i][j];
            grid[i][j]=0;
            int t1=getRightDown(grid,n,i+1,j);
            int t2=getRightDown(grid,n,i,j+1);
            grid[i][j]=val;
            return val+Math.max(t1,t2);

        }
        public int cherryPickup(int[][] grid) {

            int n=grid.length;
            int res= getRightDown(grid,n,0,0);

            return res>=0?res:0;

        }
    }

    //Approach2
    //Recursion + Memonizaion
    class Approach2{

        //sudo code
        /*
        * 1. Instead of using to recursion we simplified both recursion into one.
        *    AS going up to down and then down to up i.e. equal to moving 2 time from up to down
        * 2. We will create two coordinate system to traverse in grid i.e. i1 & j1 as one and i2 & j2
        * 3. There will be 4 combination with coordinate system:
        *       a. i1+1,j1,i2+1,j2
        *       b. i1+1,j1,i2,j2+1
        *       c. i1,j1+1,i2+1,j2
        *       d. i1,j1+1,i2,j2+1
        * 4. Issue aries when i1==i2 && j1==j2 , in that scenario we will pick cherry only one time and if not
        *    we will pick cherry present in both coordinate and marked it as zero and reverse it back at end
        *    of recursion
        * 5. Return count of cherry + max from above choice
        * 7. Apply memoization of 4-d matrix
        * 8. Memoization matrix can decrease to 3d from 4d, if we follow following principles:
        *       a. (i1+j1)+1=(i2+j2)+1
        *       b. j2=i1+j1-i2
        *    We can calculate j2 inside function than total change in variables become 3 i.e. 3d matrix
        *
        * */
        public int get(int[][] grid,int n,int i1,int j1,int i2,int j2,int[][][][] dp){
            if(i1==n-1 && j1==n-1 && i2==n-1 && j2==n-1) return grid[i1][j1];
            if(i1==n || j1==n || i2==n || j2==n || grid[i1][j1]==-1 || grid[i2][j2]==-1) return Integer.MIN_VALUE;

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

            int t1=get(grid,n,i1+1,j1,i2+1,j2,dp);
            int t2=get(grid,n,i1+1,j1,i2,j2+1,dp);
            int t3=get(grid,n,i1,j1+1,i2+1,j2,dp);
            int t4=get(grid,n,i1,j1+1,i2,j2+1,dp);

            grid[i2][j2]=v2;
            grid[i1][j1]=v1;

            return dp[i1][j1][i2][j2]= v1+v2+Math.max(Math.max(t1,t2),Math.max(t3,t4));
        }
        public int cherryPickup(int[][] grid) {

            int n=grid.length;
            int[][][][] dp=new int[n+1][n+1][n+1][n+1];

            for(int i=0;i<=n;i++){
                for(int j=0;j<=n;j++){
                    for(int k=0;k<=n;k++){
                        Arrays.fill(dp[i][j][k],-1);
                    }
                }
            }

            int res= get(grid,n,0,0,0,0,dp);

            return res>=0?res:0;

        }
    }

}
