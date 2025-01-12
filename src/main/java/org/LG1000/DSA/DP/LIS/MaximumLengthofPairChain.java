package org.LG1000.DSA.DP.LIS;
import java.util.*;
//646
//https://leetcode.com/problems/maximum-length-of-pair-chain/

public class MaximumLengthofPairChain {
    public int findLongestChain(int[][] pairs) {
        int mx=1;
        int[] dp=new int[pairs.length];
        Arrays.fill(dp,1);

        Arrays.sort(pairs,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });

        for(int i=0;i<pairs.length;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    mx=Math.max(dp[i],mx);
                }
            }
        }

        return mx;
    }
}
