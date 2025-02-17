package org.LG1000.DSA.DP.General1DDP;
import java.util.*;

//983. Minimum Cost For Tickets
//https://leetcode.com/problems/minimum-cost-for-tickets/description/
public class MinimumCostForTickets {
    //Approach1
    //Recursion + Memoization
    class Approach1{
        private int nextIndex(int[] days,int i,int day){
            int temp=days[i]+day-1;
            for(;i<days.length;i++){
                if(days[i]>temp) break;
            }
            return i;
        }
        private int get(int[] days, int[] costs,int i,int[] dp){
            if(i>=days.length) return 0;

            if(dp[i]!=-1) return dp[i];

            int t1=costs[0]+get(days,costs,i+1,dp);
            int t2=costs[1]+get(days,costs,nextIndex(days,i,7),dp);
            int t3=costs[2]+get(days,costs,nextIndex(days,i,30),dp);

            return dp[i]= Math.min(t1,Math.min(t2,t3));
        }
        public int mincostTickets(int[] days, int[] costs) {
            int n=days.length;
            int[] dp=new int[n+1];

            Arrays.fill(dp,-1);

            return get(days,costs,0,dp);
        }
    }
}
