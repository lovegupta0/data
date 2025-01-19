package org.LG1000.DSA.DP.LIS;
import java.util.*;


//1964. Find the Longest Valid Obstacle Course at Each Position
//https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/description/
public class FindtheLongestValidObstacleCourseatEachPosition {
    // BinarySearch on LIS
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n=obstacles.length;
        int[] dp=new int[n];
        //create custom binary search Tree
        TreeSet<Integer> bst=new TreeSet<>((a,b)->{
            int x=obstacles[a];
            int y=obstacles[b];
            if(x==y) return a-b;
            return x-y;
        });
        //code for BS on LIS
        for(int i=0;i<n;i++){
            int v=obstacles[i];
            Optional<Integer> upperBound=Optional.ofNullable(bst.higher(i));
            if(upperBound.isPresent()){
                //Find Lower Bound if the given element in case of elemet is first in list or not
                Optional<Integer> lowerBound=Optional.ofNullable(bst.lower(upperBound.get()));
                bst.remove(upperBound.get());
                bst.add(i);
                //Assigning dp[i] value with lower bound if present means All element less than v +1 if not dp[i]=1
                if(lowerBound.isPresent()){
                    dp[i]=dp[lowerBound.get()]+1;
                }
                else{
                    dp[i]=1;
                }
            }
            else{
                bst.add(i);
                dp[i]=bst.size();
            }
        }
        return dp;
    }
}
