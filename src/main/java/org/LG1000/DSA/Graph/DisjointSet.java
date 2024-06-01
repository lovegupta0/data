package org.LG1000.DSA.Graph;

import java.util.HashMap;

public class DisjointSet<T> {
    private HashMap<T,T> set;
    public DisjointSet(T[] edges){
        set=new HashMap<>();
        for (T edge:edges){
            set.put(edge,edge);
        }
    }
    public void makeUnion(T a,T b){
        set.put(b,set.get(a));
    }
    public T findParaent(T a){
        if(a.equals(set.get(a))) return a;
        return findParaent(set.get(a));
    }
}
