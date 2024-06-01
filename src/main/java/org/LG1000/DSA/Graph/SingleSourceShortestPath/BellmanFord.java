package org.LG1000.DSA.Graph.SingleSourceShortestPath;

import org.LG1000.DSA.Graph.WeightedGraphNode;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BellmanFord {
    public static <T> void sssp(Map<T, List<WeightedGraphNode<T>>> map, T[] vertices , T src){
        HashMap<T,Integer> distance=new HashMap<>();
        for(T ver:vertices){
            distance.put(ver,Integer.MAX_VALUE);
        }
        distance.put(src,0);
       List<WeightedGraphNode<T>>lst =map.values().stream().flatMap(e->e.stream()).collect(Collectors.toList());
        for(int i=0;i<(vertices.length-1);i++){
            for(WeightedGraphNode<T> edge:lst){
                if(distance.get(edge.src)!=Integer.MAX_VALUE && distance.get(edge.dest)>(distance.get(edge.src)+edge.weight)){
                    distance.put(edge.dest,distance.get(edge.src)+edge.weight);
                }
            }
        }
        for(WeightedGraphNode<T> edge:lst){
            if(distance.get(edge.src)!=Integer.MAX_VALUE && distance.get(edge.dest)>(distance.get(edge.src)+edge.weight)){
                System.out.println("Negative Cycle detected");
                print(lst);
                return;
            }
        }
        for(T ver:vertices){
            System.out.println(ver+"--->"+distance.get(ver));
        }
    }
    private static <T> void print( List<WeightedGraphNode<T>> lst){
        for(WeightedGraphNode<T> val:lst){
            System.out.println("( "+val.src+" )--- "+val.weight+" --->( "+val.dest+" )");
        }
    }
}
