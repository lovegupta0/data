package org.LG1000.DSA.DP.DPOnBestTimetoBuyAndSellStock;
import java.util.*;

//188. Best Time to Buy and Sell Stock IV
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
public class BestTimetoBuyandSellStockIV {
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
        public int maxProfit(int k, int[] prices) {
            int n=prices.length;
            int[][][] dp=new int[n+1][2][k+1];
            for(int i=0;i<=n;i++){
                for(int j=0;j<2;j++){
                    Arrays.fill(dp[i][j],-1);
                }
            }
            return get(prices,0,0,k,dp);
        }
    }


    //Approach2
    //Buttom up from above
    class Approach2{
        public int maxProfit(int k, int[] prices) {
            int n=prices.length;
            int[][][] dp=new int[n+1][2][k+1];
            for(int i=n;i>=0;i--){
                for(int j=0;j<2;j++){
                    for(int trans=0;trans<=k;trans++){
                        int temp;
                        if(i==n || trans==0) temp=0;
                        else if(j==0){
                            temp=Math.max(prices[i]*-1+dp[i+1][1][trans],dp[i+1][0][trans]);
                        }
                        else{
                            temp=Math.max(prices[i]+dp[i+1][0][trans-1],dp[i+1][j][trans]);
                        }
                        dp[i][j][trans]=temp;
                    }
                }
            }
            return dp[0][0][k];
        }
    }
}
