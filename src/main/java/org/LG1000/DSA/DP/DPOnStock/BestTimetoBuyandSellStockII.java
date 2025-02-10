package org.LG1000.DSA.DP.DPOnStock;
import java.util.*;

//122. Best Time to Buy and Sell Stock II
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
public class BestTimetoBuyandSellStockII {
    //Approach1
    // Recursion + memoization --> Memory Limit Exceed
    class Approach1{
        private int get(int[] prices,int prev,int i, int[][] dp){
            if(i==prices.length) return 0;

            if(dp[i][prev+1]!=-1) return dp[i][prev+1];
            int temp=0;
            if(prev==-1){
                temp=Math.max(get(prices,i,i+1,dp),temp);
            }
            else{
                int val=prices[i]-prices[prev];
                temp=Math.max(val+get(prices,-1,i+1,dp),temp);
            }
            temp=Math.max(temp,get(prices,prev,i+1,dp));

            return dp[i][prev+1]= temp;

        }
        public int maxProfit(int[] prices) {
            int n=prices.length;
            int[][] dp=new int[n+1][n+2];
            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }
            return get(prices,-1,0,dp);
        }
    }

    //Approach2
    // Recursion + memoization + space optimisation
    class Approach2{

        //Sudo code
        /*
            1. The code is derived from above
            2. Instead of using n*n space we use n*2 space complexity
            3. Here is instead of using previous index we optimise by sending only decision to buy or sell
                0 ---> to buy
                1 ---> to Sell
            4. Tricky part is to remember index where we buy the stock.
            5. Inorder to resolve it we do following things:
                i. In case of buy we subtract current index stock prices with result obtained after selling it.
                ii. In case of sell we add current stock price to the next buy
         */
        private int get(int[] prices,int buy,int i, int[][] dp){
            if(i==prices.length) return 0;

            if(dp[i][buy]!=-1) return dp[i][buy];
            int temp;
            if(buy==0){
                temp=Math.max(prices[i]*-1+get(prices,1,i+1,dp),0+get(prices,buy,i+1,dp));
            }
            else{
                temp=Math.max(prices[i]+get(prices,0,i+1,dp),0+get(prices,buy,i+1,dp));
            }

            return dp[i][buy]= temp;

        }
        public int maxProfit(int[] prices) {
            int n=prices.length;
            int[][] dp=new int[n+1][2];
            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }
            return get(prices,0,0,dp);
        }
    }

    //Approach3
    //Buttom up approach from above
    class Approach3{
        public int maxProfit(int[] prices) {
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
                        int temp=Math.max(prices[i]+dp[i+1][0],dp[i+1][j]);
                        dp[i][j]=temp;
                    }
                }
            }
            return dp[0][0];
        }
    }

    //Approach4

    class Approach4{
        public int maxProfit(int[] prices) {
            int profit=0;
            for(int i=1;i<prices.length;i++){
                if(prices[i-1]<prices[i]){
                    profit+=(prices[i]-prices[i-1]);
                }
            }
            return profit;
        }
    }

}
