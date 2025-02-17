package org.LG1000.DSA.DP.General1DDP;
import java.util.*;

//91. Decode Ways
//https://leetcode.com/problems/decode-ways/description/
public class DecodeWays {
    //Approach1
    //Recursion + Memoization
    class Approach1{
        private int get(String s,int i,int[] dp){
            if(i==s.length()) return 1;
            if(i>s.length() || s.charAt(i)=='0') return 0;

            if(dp[i]!=-1) return dp[i];

            int t1,t2;
            t1=get(s,i+1,dp);
            int c=s.charAt(i)-'0';
            t2=c==0 || (c==2 && i<s.length()-1 && (s.charAt(i+1)-'0')>6  ) || c>2?0:get(s,i+2,dp);

            return dp[i]=t1+t2;
        }
        public int numDecodings(String s) {
            int n=s.length();
            int[] dp=new int[n+1];

            Arrays.fill(dp,-1);
            return get(s,0,dp);
        }
    }
}
