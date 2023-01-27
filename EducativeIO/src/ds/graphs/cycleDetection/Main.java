package ds.graphs.cycleDetection;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int lastVertex(Graph g, int startVertex) {
    	int lastVertex = startVertex;
    	Map<Integer,Boolean> visitedMap = new HashMap<>();
    	for(int i = 0; i < g.vertices; i++) {
    		visitedMap.put(i, false);
    	}
    	DoublyLinkedList.Node tempNode = g.adjacencyList[startVertex].getHeadNode();
    	int lastNode;
    	if(tempNode != null)
    		 lastNode = (int) tempNode.data;
    	else
    		return -1;
    	
    	visitedMap.put(startVertex, true);
    	while(visitedMap.get(lastNode) != true ) {
    		visitedMap.put(lastNode, true);
    		tempNode = g.adjacencyList[lastNode].getHeadNode();
    		if(tempNode != null)
    			lastNode = (int) tempNode.data; //assuming each node has only one connected node
    		else
    			return -1;
    		}
    	return lastNode;
    }
	
	public static boolean detectCycle(Graph g){
        for(int  startVertex = 0; startVertex < g.vertices; startVertex++) {
        	if(startVertex == lastVertex(g,startVertex)) {
        		return true;
        	}
        }
        return false;
    }
    
    public static void main(String[] args) {
    	int vertices = 5;
    	Graph g = new Graph(vertices);
    	g.addEdge(0, 1);
    	g.addEdge(2, 3);
    	g.addEdge(3, 4);
    	//g.addEdge(3, 1);
    	g.addEdge(4, 2);
    	//g.printGraph();
    	for(int  i = 0; i < g.vertices; i ++)
    		System.out.println(i+" --last-> "+lastVertex(g,i));
    	
    	System.out.println(detectCycle(g));
    }

}
