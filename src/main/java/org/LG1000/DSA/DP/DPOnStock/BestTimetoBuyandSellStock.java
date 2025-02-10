package org.LG1000.DSA.DP.DPOnStock;
import java.util.*;

//121. Best Time to Buy and Sell Stock
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimetoBuyandSellStock {
    //Approach1
    // Recursion + memoization --> Memory Limit Exceed + TLE
    class Approach1{
        public int get(int[] prices,int prevPriceIdx,int i,int[][] dp){
            if(i>=prices.length) return 0;
            int temp=0;
            if(dp[prevPriceIdx][i]!=-1) return dp[prevPriceIdx][i];
            if(prevPriceIdx<(prices.length+4)){
                temp=Math.max(prices[i]-prices[prevPriceIdx],get(prices,prevPriceIdx,i+1,dp));
            }
            temp=Math.max(get(prices,prevPriceIdx,i+1,dp),temp);
            temp=Math.max(temp,get(prices,i,i+1,dp));
            return dp[prevPriceIdx][i]= temp;
        }
        public int maxProfit(int[] prices) {
            int[][] dp=new int[prices.length+5][prices.length+1];
            for(int i=0;i<=(prices.length+4);i++){
                Arrays.fill(dp[i],-1);
            }


            return get(prices,prices.length+4,0,dp);
        }
    }

    //Approach2
    // Greedy approach
    class Approach2{
        public int maxProfit(int[] prices) {
            int prevDay=Integer.MAX_VALUE;
            int profit=0;

            for(int i=0;i<prices.length;i++){
                profit=Math.max(profit,prices[i]-prevDay);
                prevDay=Math.min(prices[i],prevDay);
            }

            return profit;
        }
    }
}
