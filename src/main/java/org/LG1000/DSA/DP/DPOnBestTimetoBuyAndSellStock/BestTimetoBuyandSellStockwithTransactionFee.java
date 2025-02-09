package org.LG1000.DSA.DP.DPOnBestTimetoBuyAndSellStock;
import java.util.*;

//714. Best Time to Buy and Sell Stock with Transaction Fee
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
public class BestTimetoBuyandSellStockwithTransactionFee {
    //Approach1
    //Recursion + Memoization
    class Approach1{
        private int get(int[] prices,int buy,int i,int fee ,int[][] dp){
            if(i==prices.length) return 0;

            if(dp[i][buy]!=-1) return dp[i][buy];
            int temp;
            if(buy==0){
                temp=Math.max(prices[i]*-1+get(prices,1,i+1,fee,dp),0+get(prices,buy,i+1,fee,dp));
            }
            else{
                temp=Math.max(prices[i]-fee+get(prices,0,i+1,fee,dp),0+get(prices,buy,i+1,fee,dp));
            }

            return dp[i][buy]= temp;

        }
        public int maxProfit(int[] prices, int fee) {
            int n=prices.length;
            int[][] dp=new int[n+1][2];
            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }
            return get(prices,0,0,fee,dp);
        }
    }

    //Approach2
    //Buttom up from above
    class Approach2{
        public int maxProfit(int[] prices, int fee) {
            int n=prices.length;
            int[][] dp=new int[n+1][2];
            for(int i=n;i>=0;i--){
                for(int j=0;j<2;j++){
                    if(i==n) dp[i][j]=0;
                    else if(j==0){
                        int temp=Math.max(prices[i]*-1+dp[i+1][1],dp[i+1][0]);
                        dp[i][j]=temp;
                    }
                    else{
                        int temp=Math.max(prices[i]-fee+dp[i+1][0],dp[i+1][j]);
                        dp[i][j]=temp;
                    }
                }
            }
            return dp[0][0];
        }
    }
}
