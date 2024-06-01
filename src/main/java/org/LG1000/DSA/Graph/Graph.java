package org.LG1000.DSA.Graph;

import java.util.*;

public class Graph {
    public static <T> Map<T, List<T>> BidirectionalGraph(T[][] edges){
        Map<T,List<T>> map=new HashMap<>();
        for(int i=0;i<edges.length;i++){

            T a=edges[i][0];
            T b=edges[i][1];
            if(map.containsKey(a)){
                  if(!map.get(a).contains(b))  map.get(a).add(b);
            }
            else{
                map.put(a,new ArrayList<>(Arrays.asList(b)));
            }
            if(map.containsKey(b) ){
               if(!map.get(b).contains(a)) map.get(b).add(a);
            }
            else{
                map.put(b,new ArrayList<>(Arrays.asList(a)));
            }
        }
        return map;
    }
    public static <T> void printBFS(Map<T, List<T>> map,T src){
        Queue<T> q=new LinkedList<>();
        HashSet<T> visited=new HashSet<>();
        q.add(src);
        visited.add(src);
        while (!q.isEmpty()){
            T temp=q.poll();

            for(T val:map.get(temp)){
                if(!visited.contains(val)) {
                    q.add(val);
                    visited.add(val);
                }
            }
            System.out.println(temp);
        }
    }
    public static <T> void printGraph(Map<T, List<T>> graph) {
        for (Map.Entry<T, List<T>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (T node : entry.getValue()) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public static <T> void  printDFS(Map<T, List<T>> map,T src){
        DFS(map,src,new HashSet<>());
    }
    private static <T> void DFS(Map<T, List<T>> map,T src,HashSet<T> visited){
        visited.add(src);
        for(T val: map.get(src)){
            if(!visited.contains(val)){
                DFS(map,val,visited);
            }
        }
        System.out.println(src);

    }
    public static <T> Map<T,List<T>> directionalGraph(T[][] edges){
        Map<T,List<T>> map=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            T a=edges[i][0];
            T b=edges[i][1];
            if(map.containsKey(a)){
                map.get(a).add(b);
            }
            else{
                map.put(a,new ArrayList<>(Arrays.asList(b)));
            }

        }

        return map;
    }

}
