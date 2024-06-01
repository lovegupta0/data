package org.LG1000.DSA.Graph.SingleSourceShortestPath;

import org.LG1000.DSA.Graph.WeightedGraphNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    public static <T> void SSSP(Map<T, List<WeightedGraphNode<T>>> map, T[] vertices , T src){
        HashMap<T,Integer> distance=new HashMap<>();
        for(T ver:vertices){
            distance.put(ver,Integer.MAX_VALUE-100000);
        }
        distance.put(src,0);
        PriorityQueue<WeightedGraphNode<T>> pq=new PriorityQueue<>();
        for(WeightedGraphNode<T> ver:map.get(src)){
            pq.add(ver);
        }
        while (!pq.isEmpty()){
            WeightedGraphNode p=pq.poll();
            if(distance.get(p.dest)>(distance.get(p.src)+p.weight)){
                distance.put((T) p.dest,distance.get(p.src)+p.weight);
                for(WeightedGraphNode<T> ver:map.get(p.dest)){
                    pq.add(ver);
                }
            }
        }
        for(T ver:vertices){
            System.out.println(ver+"--->"+distance.get(ver));
        }
    }
}
