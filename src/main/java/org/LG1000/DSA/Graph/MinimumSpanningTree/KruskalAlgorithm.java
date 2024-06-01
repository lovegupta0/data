package org.LG1000.DSA.Graph.MinimumSpanningTree;

import org.LG1000.DSA.Graph.DisjointSet;
import org.LG1000.DSA.Graph.WeightedGraphNode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KruskalAlgorithm {
    public static<T> int MST(Map<T, List<WeightedGraphNode<T>>> map, T[] vertices ){
        int sum=0;
        DisjointSet<T> set=new DisjointSet<>(vertices);
        List<WeightedGraphNode<T>>edges =map.values().stream().flatMap(e->e.stream()).sorted().collect(Collectors.toList());
        for(WeightedGraphNode<T> edge:edges){
            T parentOfSrc=set.findParaent(edge.src);
            T parentOfDest= set.findParaent(edge.dest);
            if(!parentOfSrc.equals(parentOfDest)){
                sum+=edge.weight;
                set.makeUnion(parentOfSrc,parentOfDest);
            }
        }
        return sum;
    }
}
