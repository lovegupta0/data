package org.LG1000.DSA.DP.General1DDP;
import java.util.*;

//322. Coin Change
//https://leetcode.com/problems/coin-change/description/
public class CoinChange {
    //Approach1
    //Recursion + Memoization
    class Approach1{
        private int maxValue=100000;
        private int get(int[] coins, int amount, int i,int[][] dp){
            if(amount<0) return maxValue;
            if(i==coins.length){
                if(amount==0) return 0;
                return maxValue;
            }
            if(dp[i][amount]!=-1) return dp[i][amount];
            return dp[i][amount]=Math.min(get(coins,amount,i+1,dp),1+get(coins,amount-coins[i],i,dp));

        }
        public int coinChange(int[] coins, int amount) {
            int[][] dp=new int[coins.length+1][amount+1];
            for(int i=0;i<=coins.length;i++){
                Arrays.fill(dp[i],-1);
            }
            int res=get(coins,amount,0,dp);
            return res>=maxValue?-1:res;
        }
    }

    //Approach2
    //Buttom up
    class Approach2{
        public int coinChange(int[] coins, int amount) {
            int[][] dp=new int[coins.length+1][amount+1];
            int maxValue=100000;
            for(int i=0;i<=amount;i++){
                dp[0][i]=maxValue;
                if(i%coins[0]==0){
                    dp[1][i]=i/coins[0];
                }
                else{
                    dp[1][i]=maxValue;
                }
            }
            for(int i=0;i<=coins.length;i++){
                dp[i][0]=0;
            }
            for(int i=2;i<=coins.length;i++){
                for(int j=1;j<=amount;j++){
                    if(coins[i-1]<=j){
                        dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                    }
                    else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
            return dp[coins.length][amount]>=maxValue?-1:dp[coins.length][amount];
        }
    }
}
