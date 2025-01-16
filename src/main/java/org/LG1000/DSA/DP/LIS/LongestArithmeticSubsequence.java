package org.LG1000.DSA.DP.LIS;
import java.util.*;

//1027
//https://leetcode.com/problems/longest-arithmetic-subsequence/description/
public class LongestArithmeticSubsequence {
    // Approach 1
    //Recursion + Memonization ---> TLE
    class Approach1{
        private int get(int[] nums,int i,int j,int[][] dp){
            if(i==nums.length-1 || nums.length==j) return 0;

            if(dp[i][j]!=-1) return dp[i][j];

            int temp=get(nums,i,j+1,dp);
            temp=Math.max(get(nums,i+1,j,dp),temp);
            int diff=nums[i]-nums[j];

            int count=1;
            int prev=j;
            for(int k=j+1;k<nums.length;k++){
                if(nums[k]-nums[prev]==diff){
                    count++;
                    prev=k;
                }
            }
            return dp[i][j]= Math.max(temp,count);
        }
        public int longestArithSeqLength(int[] nums) {
            int n=nums.length;
            int[][] dp=new int[n+1][n+1];
            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }
            return get(nums,0,0,dp);
        }
    }


    //Approach -2
    class Approach2{
        private int get(int[] nums,int diff){
            int mx=1;
            Map<Integer,Integer> map=new HashMap<>();

            for(int i=0;i<nums.length;i++){
                int prev=nums[i]+diff;
                map.put(nums[i],map.getOrDefault(prev,0)+1);
                mx=Math.max(mx,map.get(nums[i]));
            }

            return mx;
        }
        public int longestArithSeqLength(int[] nums) {
            int maxValue=Arrays.stream(nums).max().orElse(0);
            int res=1;
            for(int i=maxValue*-1;i<maxValue;i++){
                res=Math.max(res,get(nums,i));
            }
            return res;
        }
    }


    //Approach-2
    // Buttoms up
    class Approach3{
        public int longestArithSeqLength(int[] nums) {
            int n=nums.length;
            int[][] dp=new int[n][1001];
            int mx=2;

            for(int i=0;i<n;i++){
                for(int j=0;j<i;j++){
                    int diff=nums[i]-nums[j]+500;
                    dp[i][diff]=dp[j][diff]>0?dp[j][diff]+1:2;

                    mx=Math.max(dp[i][diff],mx);
                }
            }

            return mx;
        }
    }
}
