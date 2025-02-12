package org.LG1000.DSA.DP.MCM;
import java.util.*;

//312. Burst Balloons
//https://leetcode.com/problems/burst-balloons/description/
public class BurstBalloons {

    //Approach
    /*
    * Input: nums = [3,1,5,8]
      Output: 167
      Explanation:
      nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
      coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
    *  As we see we will choose optimal value to calculate from i-n
    * Instead for moving forward, we try to move from backward to forward
    * now make arr as [1,3,1,5,8,1]
    * so last value will be n i.e. 8
    *   -> 1*8*1=8 now go 2nd last
    *   -> 1*3*8=24 now go 3rd last
    *   -> 3*5*8=120 now 4th last
    *   -> 3*1*5=15 total=167
    *
    * base condition: start>end
    *  pass i=1,e=n
    * will loop k=i -> k<=e
    * left=get(nums,i,k-1)
    * right=get(nums,k+1,e)
    * current_cost=left+right+ nums[i-1]*nums[k]*nums[j+1]
    *   dry run: lets 8 i.e. k=4 is last value
    *       nums[i-1]: i=1 & i-1=0 -> 1 value
    *       nums[j+1]: j=4 & j+1=5 -> 1 value
    *
    * go on...
    *
    * */
    private int get(int[] nums,int i,int e,int[][] dp){
        if( i>e) return 0;
        if(dp[i][e]!=-1) return dp[i][e];
        int mx=-1;
        for(int k=i;k<=e;k++){
            int temp=get(nums,i,k-1,dp)+get(nums,k+1,e,dp)+nums[i-1]*nums[k]*nums[e+1];

            mx=Math.max(mx,temp);
        }

        return dp[i][e]=mx;
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        int[][] dp=new int[n+2][n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        for(int i=0;i<=n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return get(arr,1,n,dp);
    }
}
