package org.LG1000.DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphMatix {
    public static int[][] directedGraph(Integer[][] edges,int vertices){
        int[][] graph=new int[vertices][vertices];
        for(int i=0;i<vertices;i++){
            Arrays.fill(graph[i],0);
        }
        for(int i=0;i<edges.length;i++){

            int a=edges[i][0];
            int b=edges[i][1];
           graph[a][b]=1;
        }
        return graph;
    }
    public static int[][] weightedDirectedGraph(Integer[][] edges,int[] weight,int vertices){
        int[][] graph=new int[vertices][vertices];
        for(int i=0;i<vertices;i++){
            Arrays.fill(graph[i],1000000);
        }
        for(int i=0;i<edges.length;i++){

            int a=edges[i][0];
            int b=edges[i][1];
            graph[a][b]=weight[i];
        }
        return graph;
    }
}
