package org.LG1000.DSA.DP.LCS;
import java.util.*;

//5. Longest Palindromic Substring
//https://leetcode.com/problems/longest-palindromic-substring/description/
public class LongestPalindromicSubstring {
    private boolean isPalindrom(String s,int i,int j,int[][] dp){
        while(i<j){
            if(dp[i][j]!=-1) return dp[i][j]==0?false:true;
            if(s.charAt(i)!=s.charAt(j)){
                dp[i][j]=0;
                return false;
            }
            i++;
            j--;
        }
        dp[i][j]=1;
        return true;
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        int mx=1;
        int idx=0;
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrom(s,i,j,dp)){
                    if((j-i+1)>mx){
                        mx=j-i+1;
                        idx=i;
                    }
                }
            }
        }

        return s.substring(idx,idx+mx);
    }
}
