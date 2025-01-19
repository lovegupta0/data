package org.LG1000.DSA.DP.LCS;

//1312. Minimum Insertion Steps to Make a String Palindrome
//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
public class MinimumInsertionStepstoMakeaStringPalindrome {

    //Buttom Up Approach
    public int minInsertions(String s) {
        String t=new StringBuilder(s).reverse().toString();
        int n=s.length();
        int[][] dp=new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return n-dp[n][n];
    }
}
