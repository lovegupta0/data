package org.LG1000.DSA.DP.LIS;
import java.util.*;

//354
//https://leetcode.com/problems/russian-doll-envelopes/description/

public class RussianDollEnvelopes {
    //Approach-1
    //Buttoms up ----> TLE
    class Approach1{
        public int maxEnvelopes(int[][] envelopes) {
            int n=envelopes.length;
            int mx=1;
            int[] dp=new int[n];
            Arrays.fill(dp,1);

            Arrays.sort(envelopes,(a,b)->{
                if(a[0]==b[0]) return a[1]-b[1];
                return a[0]-b[0];
            });

            for(int i=0;i<n;i++){
                for(int j=0;j<i;j++){
                    if(envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1]){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                        mx=Math.max(dp[i],mx);
                    }
                }
            }

            return mx;

        }
    }

    // Approach 2
    // Binary Search on LIS for optimal solution
    // T-> O(nlogn)
    class Approach2{
        public int maxEnvelopes(int[][] envelopes) {
            int n=envelopes.length;

            TreeSet<Integer> bst=new TreeSet<>();
            //sorting ASC for Index 0 & if equal Index 0 Than sorting DESC Index 1
            Arrays.sort(envelopes,(a,b)->{
                if(a[0]==b[0]) return b[1]-a[1];
                return a[0]-b[0];
            });

            //Once it is sorted collect element for 2nd index i.e. 1
            List<Integer> lst=new ArrayList<>();
            for(int i=0;i<n;i++){
                lst.add(envelopes[i][1]);
            }

            //Apply Binary Search LIS technique on collected list from above
            for(int i=0;i<n;i++){
                if(!bst.contains(lst.get(i))){
                    Optional<Integer> upperBound=Optional.ofNullable(bst.higher(lst.get(i)));
                    if(upperBound.isPresent()){
                        bst.remove(upperBound.get());
                    }
                    bst.add(lst.get(i));
                }
            }

            return bst.size();

        }
    }
}
