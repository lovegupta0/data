package org.LG1000.DSA.DP.DPOnStock;
import java.util.*;
//123. Best Time to Buy and Sell Stock III
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
public class BestTimetoBuyandSellStockIII {
    //Approach1
    //Recursion + Memoization
    class Approach1{
        private int get(int[] prices,int buy,int i,int trans,int[][][] dp){
            if(i==prices.length || trans==0) return 0;

            if(dp[i][buy][trans]!=-1) return dp[i][buy][trans];
            int temp;
            if(buy==0){
                temp=Math.max(prices[i]*-1+get(prices,1,i+1,trans,dp),0+get(prices,buy,i+1,trans,dp));
            }
            else{
                temp=Math.max(prices[i]+get(prices,0,i+1,trans-1,dp),0+get(prices,buy,i+1,trans,dp));
            }

            return dp[i][buy][trans]= temp;

        }

        public int maxProfit(int[] prices) {
            int n=prices.length;
            int[][][] dp=new int[n+1][2][3];
            for(int i=0;i<=n;i++){
                for(int j=0;j<2;j++){
                    Arrays.fill(dp[i][j],-1);
                }
            }
            return get(prices,0,0,2,dp);
        }
    }

    //Approach2
    //Buttom up from above
    class Approach2{
        public int maxProfit(int[] prices) {
            int n=prices.length;
            int[][][] dp=new int[n+1][2][3];
            for(int i=n;i>=0;i--){
                for(int j=0;j<2;j++){
                    for(int k=0;k<3;k++){
                        int temp;
                        if(i==n || k==0) temp=0;
                        else if(j==0){
                            temp=Math.max(prices[i]*-1+dp[i+1][1][k],dp[i+1][0][k]);
                        }
                        else{
                            temp=Math.max(prices[i]+dp[i+1][0][k-1],dp[i+1][j][k]);
                        }
                        dp[i][j][k]=temp;
                    }
                }
            }
            //Return dp[0][0][2] as transaction is 2
            return dp[0][0][2];
        }
    }
}
