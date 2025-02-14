package org.LG1000.DSA.DP.MCM;
import java.util.*;

//132. Palindrome Partitioning II
//https://leetcode.com/problems/palindrome-partitioning-ii/description/
public class PalindromePartitioningII {
    //Approach1
    //Recursion + Memoization --> TLE
    //TC -> o(N^3)
    class Approach1{
        private boolean isPalindrome(String s){
            int i=0;
            int j=s.length()-1;

            while(i<j){
                if(s.charAt(i)!=s.charAt(j)) return false;
                i++;
                j--;
            }

            return true;
        }
        private int get(String s,HashMap<String,Integer> dp){
            if(s.length()==0 || isPalindrome(s)) return 0;

            if(dp.containsKey(s)) return dp.get(s);
            int min=Integer.MAX_VALUE;
            for(int i=1;i<s.length();i++){
                String l=s.substring(0,i);
                String r=s.substring(i);
                int lv=0;
                int rv=0;
                if(dp.containsKey(l)){
                    lv=dp.get(l);
                }
                else{
                    lv=get(l,dp);
                }
                if(dp.containsKey(r)){
                    rv=dp.get(r);
                }
                else{
                    rv=get(r,dp);
                }
                int temp=1+lv+rv;
                min=Math.min(min,temp);
            }

            dp.put(s,min);
            return min;
        }
        public int minCut(String s) {
            HashMap<String,Integer> dp=new HashMap<>();
            return get(s,dp);
        }
    }

    //Approach2
    //Buttom up
    class Approach2{
        public int minCut(String s) {
            int n = s.length();
            int[] dp = new int[n];
            boolean[][] P = new boolean[n][n];

            Arrays.fill(dp,Integer.MAX_VALUE);

            // Length = 1 substrings are always palindromes
            for (int i = 0; i < n; i++) {
                P[i][i] = true;
            }

            // Length = 2+ substrings
            for (int L = 2; L <= n; L++) {
                for (int i = 0; i < n - L + 1; i++) {
                    int j = i + L - 1;

                    if (L == 2) {
                        P[i][j] = (s.charAt(i) == s.charAt(j));
                    } else {
                        P[i][j] = (s.charAt(i) == s.charAt(j)) && P[i + 1][j - 1];
                    }
                }
            }

            // Compute minimum cuts using dynamic programming
            for (int i = 0; i < n; i++) {
                if (P[0][i]) {
                    dp[i] = 0;
                } else {
                    for (int k = 0; k < i; k++) {
                        if (P[k + 1][i]) {
                            dp[i] = Math.min(dp[i],1+dp[k]);
                        }
                    }
                }
            }

            return dp[n - 1];
        }
    }
}
