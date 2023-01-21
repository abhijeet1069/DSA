package ds.graphs.dfs;

import ds.graphs.bfs.DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

class CheckDFS {
    //Depth First Traversal of Graph g

    public static int nextNode(Graph g, Map<Integer,Boolean> map, int node){
        int res;

    }
    public static String dfs(Graph g) {
        String result = "";
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i = 0; i < g.vertices; i++){
            map.put(i,false);
        }
        for(int i = 0; i < g.vertices; i++){

        }
        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        ds.graphs.bfs.Graph graph = new ds.graphs.bfs.Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.printGraph();
        //System.out.println(CheckBFS.bfs(graph));
    }
}
