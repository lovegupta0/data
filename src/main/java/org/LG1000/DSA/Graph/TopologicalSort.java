package org.LG1000.DSA.Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TopologicalSort {
    public static <T> void sort(Map<T, List<T>> map, T[] src){
        Stack<T> stack=new Stack<>();
        HashSet<T> visited=new HashSet<>();
        for(T val:src){
            if(!visited.contains(val)){
                toplogicalSort(map,val,visited,stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }
    private static <T> void toplogicalSort(Map<T, List<T>> map, T src, HashSet<T> visited,Stack<T> stack){
        visited.add(src);
        if(map.containsKey(src)) {
            for (T val : map.get(src)) {
                if (!visited.contains(val)) {
                    toplogicalSort(map, val, visited, stack);
                }
            }
        }
        stack.add(src);
    }


}
