package org.LG1000.DSA.Graph;

public class WeightedGraphNode<T> implements Comparable<WeightedGraphNode> {
    public T src;
    public T dest;
    public int weight;
    public WeightedGraphNode(){

    }
    public WeightedGraphNode(T src,T dest,int weight){
        this.src=src;
        this.dest=dest;
        this.weight=weight;
    }
    @Override
    public int compareTo(WeightedGraphNode obj){
        return Integer.compare(this.weight,obj.weight);
    }
}
