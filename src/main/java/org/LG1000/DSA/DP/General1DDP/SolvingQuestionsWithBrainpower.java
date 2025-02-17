package org.LG1000.DSA.DP.General1DDP;
import java.util.*;

//2140. Solving Questions With Brainpower
//https://leetcode.com/problems/solving-questions-with-brainpower/description/
public class SolvingQuestionsWithBrainpower {
    //Approach1
    //Recursion + Memoization
    class Approach1{
        private long get(int[][] nums,int i, long[] dp){
            if(i>=nums.length) return 0;
            if(dp[i]!=-1) return dp[i];
            long temp=get(nums,i+1,dp);
            int a=nums[i][0];
            int b=nums[i][1];
            temp=Math.max(temp,a+get(nums,i+b+1,dp));
            return dp[i]= temp;
        }
        public long mostPoints(int[][] questions) {
            int n=questions.length;
            long[] dp=new long[n+1];
            Arrays.fill(dp,-1);
            return get(questions,0,dp);

        }
    }
}
