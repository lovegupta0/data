package org.LG1000.DSA.DP.LCS;
import java.util.*;
//https://www.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
public class ShortestCommonSupersequence {
    //Approach 1
    // Recurrsion + memonization
    class Approach1{
        int[][] t;

        public int solve(String s1, String s2, int m, int n) {
            // base condition
            if (m == 0 || n == 0) {
                return m + n;
            }

            if (t[m][n] != -1) {
                return t[m][n];
            }
            // step 2
            if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                return t[m][n] = 1 + solve(s1, s2, m - 1, n - 1);
            } else { //step 3
                return t[m][n] = 1 + Math.min(solve(s1, s2, m - 1, n), solve(s1, s2, m, n - 1));
            }
        }

        // Function to find length of shortest common supersequence of two strings.
        public int shortestCommonSupersequence(String s1, String s2, int m, int n) {
            t = new int[m + 1][n + 1];
            for (int[] row : t) {
                Arrays.fill(row, -1);
            }
            return solve(s1, s2, m, n);
        }
    }

    //Approach 2
    // Buttom up DP
    // we need to write recurrsion from backward to convert into bottom up dp
    class Approach2{
        //Here code from recurrsion + memonization is used to convert Bottom up dp
        public int shortestCommonSupersequence(String s1, String s2, int m, int n) {
            int[][] t = new int[m + 1][n + 1];

            for (int i = 0; i < m + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    if (i == 0 || j == 0) {
                        t[i][j] = i + j; // base condition, also used to initialization step
                    } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) { //step 2 from above
                        t[i][j] = 1 + t[i - 1][j - 1];
                    } else { // step 3 from above
                        t[i][j] = 1 + Math.min(t[i - 1][j], t[i][j - 1]);
                    }
                }
            }

            return t[m][n];
        }
    }

    //Approach 3
    // From LCS
    class Approach3{
        public int shortestCommonSupersequence(String s1, String s2, int m, int n) {
            int[][] t = new int[m + 1][n + 1];

            for (int i = 0; i < m + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    if (i == 0 || j == 0)
                        t[i][j] = 0;
                    else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                        t[i][j] = 1 + t[i - 1][j - 1];
                    else
                        t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }

            int LCS = t[m][n];

            int letters_from_s1 = m - LCS;
            int letters_from_s2 = n - LCS;

            return LCS + letters_from_s1 + letters_from_s2;
        }
    }


}
