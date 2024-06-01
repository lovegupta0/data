package org.LG1000.DSA.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Data {
    public static int INF=99999;
    public static Integer[][] weightedEdges = {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 5}, {6, 4}, {5, 6}};
    public static int[] weights={4, 2, 5, 10, 3, 8, 6};
    public static Integer[] weightedVertices={1,2,3,4,5,6};
    public static String[][] topoData={{"A","C"},{"C","E"},{"E","H"},{"E","F"},{"F","G"},{"D","F"},{"B","D"},{"B","C"}};
    public static String[] topoVertices={"A","B","C","D","E","F","G","H"};
    public static String[][] ssspWeightedEdge={{"A","C"},{"C","D"},{"D","C"},{"D","B"},{"B","A"},{"E","D"},{"E","B"},{"A","D"}};
    public static int[] ssspWeight={6,2,1,1,3,2,4,6};
    public static int[] ssspWeightBellmanFord={6,2,1,1,3,2,4,-6};
    public static String[] ssspVertices={"A","B","C","D","E"};
    public static int graph[][] = { { 0, 5, INF, 10 },
            { INF, 0, 3, INF },
            { INF, INF, 0, 1 },
            { INF, INF, INF, 0 } };
    public static Integer[][] getUndirectedGraphData(){
        Integer[][] arr=new Integer[14][2];
        arr[0][0]=1;
        arr[0][1]=2;
        arr[1][0]=1;
        arr[1][1]=3;
        arr[2][0]=1;
        arr[2][1]=4;
        arr[3][0]=3;
        arr[3][1]=1;
        arr[4][0]=3;
        arr[4][1]=4;
        arr[5][0]=4;
        arr[5][1]=1;
        arr[6][0]=4;
        arr[6][1]=3;
        arr[7][0]=4;
        arr[7][1]=2;
        arr[8][0]=4;
        arr[8][1]=5;
        arr[9][0]=2;
        arr[9][1]=1;
        arr[10][0]=2;
        arr[10][1]=4;
        arr[11][0]=2;
        arr[11][1]=5;
        arr[12][0]=5;
        arr[12][1]=2;
        arr[13][0]=5;
        arr[13][1]=4;
        return arr;
    }
    public static String[][] getGraphStringData(){
        String[][] stringEdges = { {"A", "B"}, {"B", "C"}, {"C", "D"}, {"D", "A"}, {"B", "D"} };
        return stringEdges;
    }
    public static Integer[][] data1(){
        Integer[][] unweightedEdges = {
                {1, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 5}, {4, 6}, {5, 6}
        };
        return unweightedEdges;
    }
}
