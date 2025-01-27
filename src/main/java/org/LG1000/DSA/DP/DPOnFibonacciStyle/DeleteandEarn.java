package org.LG1000.DSA.DP.DPOnFibonacciStyle;
import java.util.*;

//740. Delete and Earn
//https://leetcode.com/problems/delete-and-earn/description/
public class DeleteandEarn {

    //Approach1
    //Recurrsion + Memonization
    //Note: It is varient of House Robber problem

    class Approach1{
        private int get(List<Integer> lst,int n,Map<Integer,Integer> map,int[] dp){
            if(n<=0) return 0;
            if(dp[n]!=-1) return dp[n];

            int t1=lst.get(n-1)*map.get(lst.get(n-1));
            if(n>1 && lst.get(n-2)+1==lst.get(n-1)){
                t1+=get(lst,n-2,map,dp);
            }
            else{
                t1+=get(lst,n-1,map,dp);
            }
            int t2=get(lst,n-1,map,dp);

            return dp[n]= Math.max(t1,t2);
        }
        public int deleteAndEarn(int[] nums) {
            int n=nums.length;
            int[] dp=new int[n+1];
            Arrays.fill(dp,-1);
            Map<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
            List<Integer> lst=new ArrayList<>(map.keySet());
            Collections.sort(lst);
            return get(lst,map.size(),map,dp);


        }
    }

    //Approach2
    //Buttom approach, constructed from above

    class Approach2{
        class Solution {
            public int deleteAndEarn(int[] nums) {
                int n=nums.length;
                Map<Integer,Integer> map=new HashMap<>();
                for(int i=0;i<n;i++){
                    map.put(nums[i],map.getOrDefault(nums[i],0)+1);
                }
                List<Integer> lst=new ArrayList<>(map.keySet());
                Collections.sort(lst);
                int[] dp=new int[lst.size()+1];
                for(int i=0;i<=lst.size();i++){

                    if(i==0) dp[i]=0;
                    else{
                        int t1=0;
                        int t2=0;
                        t1=lst.get(i-1)*map.get(lst.get(i-1));
                        if(i>1 && lst.get(i-2)+1==lst.get(i-1)){
                            t1+=dp[i-2];
                        }
                        else{
                            t1+=dp[i-1];
                        }
                        t2=dp[i-1];
                        dp[i]=Math.max(t1,t2);
                    }
                }
                return dp[lst.size()];
            }
        }
    }
}
