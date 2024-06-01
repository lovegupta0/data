package org.LG1000.DSA.Graph.MinimumSpanningTree;

import org.LG1000.DSA.Graph.WeightedGraphNode;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public static<T> int MST(Map<T, List<WeightedGraphNode<T>>> map, T[] vertices ){
        int sum=0;
        HashSet<T> visited=new HashSet<>();
        PriorityQueue<WeightedGraphNode<T>> minHeap=new PriorityQueue<>();
        visited.add(vertices[0]);
        for(WeightedGraphNode<T> val:map.get(vertices[0])){
            minHeap.add(val);
        }
        while (!minHeap.isEmpty()){
            WeightedGraphNode<T> p=minHeap.poll();
            if(visited.contains(p.dest)) continue;
            visited.add(p.dest);
            sum+=p.weight;
            for(WeightedGraphNode edge:map.get(p.dest)){
                if(!visited.contains(edge.dest)){
                    minHeap.add(edge);
                }
            }
        }

        return sum;
    }
}
