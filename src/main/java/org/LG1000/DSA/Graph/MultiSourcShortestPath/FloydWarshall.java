package org.LG1000.DSA.Graph.MultiSourcShortestPath;

import org.LG1000.DSA.Graph.Data;

public class FloydWarshall {
    public static int[][] mssp(int[][] graph){

        for(int via=0;via<graph.length;via++){
            for(int i=0;i<graph.length;i++){
                for(int j=0;j<graph.length;j++){
                    graph[i][j]=Math.min(graph[i][j],graph[i][via]+graph[via][j]);
                }
            }
        }


        return graph;
    }
    public static void printSolution(int dist[][]) {
        System.out.println(
                "The following matrix shows the shortest "
                        + "distances between every pair of vertices");
        int V= dist.length;
        int INF= Data.INF;
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
