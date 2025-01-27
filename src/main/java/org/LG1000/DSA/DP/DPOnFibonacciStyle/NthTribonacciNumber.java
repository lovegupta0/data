package org.LG1000.DSA.DP.DPOnFibonacciStyle;
import java.util.*;

//1137. N-th Tribonacci Number
//https://leetcode.com/problems/n-th-tribonacci-number/description/
public class NthTribonacciNumber {

    //Approach1
    //Recurrsion + Memonization
    class Approach1{
        private int get(int n,int[] arr){
            if(n==0) return 0;
            if(n==1) return 1;
            if(n==2) return 1;
            if(arr[n]!=-1) return arr[n];

            return arr[n]=get(n-1,arr)+get(n-2,arr)+get(n-3,arr);

        }
        public int tribonacci(int n) {
            int[] arr=new int[n+1];
            Arrays.fill(arr,-1);
            return get(n,arr);
        }
    }

    //Approach2
    //Buttom up
    class Approach2{
        public int tribonacci(int n) {
            int[] dp=new int[n+1];

            for(int i=0;i<=n;i++){
                if(i==0) dp[i]=0;
                else if(i==1) dp[i]=1;
                else if(i==2) dp[i]=1;
                else dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }

            return dp[n];
        }
    }
}
