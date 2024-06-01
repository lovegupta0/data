package org.LG1000.DSA.Graph;

import java.util.*;

public class WeightedGraph {
    public static <T> Map<T, List<WeightedGraphNode<T>>> BiDirectionalweightedGraph(T[][] edges, int[] weights){
        Map<T,List<WeightedGraphNode<T>>> map=new HashMap<>();
        for (int i=0;i<edges.length;i++) {
            T src=edges[i][0];
            T dest=edges[i][1];
            int weight=weights[i];
            if(map.containsKey(src)){
                map.get(src).add(new WeightedGraphNode<>(src,dest,weight));
            }
            else {
                map.put(src,new ArrayList<>(List.of(new WeightedGraphNode<>(src,dest,weight))));
            }
            if(map.containsKey(dest)){
                map.get(dest).add(new WeightedGraphNode<>(dest,src,weight));
            }
            else {
                map.put(dest,new ArrayList<>(List.of(new WeightedGraphNode<>(dest,src,weight))));
            }

        }
        return map;
    }
    public static <T> void printBFS(Map<T, List<WeightedGraphNode<T>>> map,T src){
        Queue<T> q=new LinkedList<>();
        HashSet<T> visited=new HashSet<>();
        q.add(src);
        visited.add(src);
        while (!q.isEmpty()){
            T temp=q.poll();
            for(WeightedGraphNode<T> val:map.get(temp)){
                if(!visited.contains(val.dest)) {
                    q.add(val.dest);
                    visited.add(val.dest);
                    System.out.println("( "+val.src+" )--- "+val.weight+" --->( "+val.dest+" )");
                }
            }

        }
    }
    public static <T> Map<T, List<WeightedGraphNode<T>>> directionalweightedGraph(T[][] edges, int[] weights){
        Map<T,List<WeightedGraphNode<T>>> map=new HashMap<>();
        for (int i=0;i<edges.length;i++) {
            T src=edges[i][0];
            T dest=edges[i][1];
            int weight=weights[i];
            if(map.containsKey(src)){
                map.get(src).add(new WeightedGraphNode<>(src,dest,weight));
            }
            else {
                map.put(src,new ArrayList<>(List.of(new WeightedGraphNode<>(src,dest,weight))));
            }

        }
        return map;
    }
    public static <T> void printDirectionalBFS(Map<T, List<WeightedGraphNode<T>>> map,T src){
        Queue<T> q=new LinkedList<>();
        HashSet<T> visited=new HashSet<>();
        q.add(src);
        visited.add(src);
        while (!q.isEmpty()){
            T temp=q.poll();
            if(map.containsKey(temp)){
                for(WeightedGraphNode<T> val:map.get(temp)){
                    if(!visited.contains(val.dest)) {
                        q.add(val.dest);
                        visited.add(val.dest);
                        System.out.println("( "+val.src+" )--- "+val.weight+" --->( "+val.dest+" )");
                    }
                }
            }

        }
    }

    public static <T> void printDFS(Map<T, List<WeightedGraphNode<T>>> map,T src){
        DFS(map,src,new HashSet<>());
    }
    private static <T> void DFS(Map<T, List<WeightedGraphNode<T>>> map,T src,HashSet<T> visited){
        visited.add(src);
        for(WeightedGraphNode<T> val:map.get(src)){
            if(!visited.contains(val.dest)){
                DFS(map,val.dest,visited);
                System.out.println("( "+val.src+" )--- "+val.weight+" --->( "+val.dest+" )");
            }

        }
    }
}
