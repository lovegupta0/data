package org.LG1000.DSA.Graph;

import org.LG1000.DSA.Graph.MinimumSpanningTree.KruskalAlgorithm;
import org.LG1000.DSA.Graph.MinimumSpanningTree.PrimsAlgorithm;
import org.LG1000.DSA.Graph.MultiSourcShortestPath.FloydWarshall;
import org.LG1000.DSA.Graph.SingleSourceShortestPath.BellmanFord;
import org.LG1000.DSA.Graph.SingleSourceShortestPath.Dijkstra;

import java.util.*;
import java.util.List;
import java.util.Map;



public class Main {
    public static void main(String[] args){
        Map<Integer, List<Integer>> graphArrayList= Graph.BidirectionalGraph(Data.getUndirectedGraphData());
        Graph.printGraph(graphArrayList);
        System.out.println("BFS:");
        Graph.printBFS(graphArrayList,1);
        System.out.println("DFS:");
        Graph.printDFS(graphArrayList,1);

        Map<String, List<String>> directionalgraph=Graph.directionalGraph(Data.getGraphStringData());
        Graph.printGraph(directionalgraph);
        System.out.println("BFS:");
        Graph.printBFS(directionalgraph,"A");
        System.out.println("DFS:");
        Graph.printDFS(directionalgraph,"A");
        System.out.println("weighted Graph");
        Map<Integer,List<WeightedGraphNode<Integer>>> weightedGraph=WeightedGraph.directionalweightedGraph(Data.weightedEdges,Data.weights);
        System.out.println("BFS:");
        WeightedGraph.printBFS(weightedGraph,1);
        System.out.println("DFS:");
        WeightedGraph.printDFS(weightedGraph,1);

        System.out.println("TopoSort");
        Map<String, List<String>> topo= Graph.directionalGraph(Data.topoData);
        TopologicalSort.sort(topo,Data.topoVertices);
        System.out.println("Dijkstra");
        Map<String,List<WeightedGraphNode<String>>> ssspGraph=WeightedGraph.directionalweightedGraph(Data.ssspWeightedEdge,Data.ssspWeight);
        Dijkstra.SSSP(ssspGraph,Data.ssspVertices,"E");
        System.out.println("BellMan's Ford");
        BellmanFord.sssp(ssspGraph,Data.ssspVertices,"E");
        Map<String,List<WeightedGraphNode<String>>> ssspGraphNegCycle=WeightedGraph.directionalweightedGraph(Data.ssspWeightedEdge,Data.ssspWeightBellmanFord);
        BellmanFord.sssp(ssspGraphNegCycle,Data.ssspVertices,"E");
        System.out.println("FloyWarshall");
        FloydWarshall.mssp(Data.graph);
        FloydWarshall.printSolution(Data.graph);
        System.out.println("Prim's Algorithm");
        System.out.println(PrimsAlgorithm.MST(WeightedGraph.BiDirectionalweightedGraph(Data.weightedEdges,Data.weights),Data.weightedVertices));
        System.out.println("Kruskal Algorithm");
        System.out.println(KruskalAlgorithm.MST(WeightedGraph.BiDirectionalweightedGraph(Data.weightedEdges,Data.weights),Data.weightedVertices));


    }
}
