package ds.graphs.bfs;

import java.util.HashMap;
import java.util.Map;

class CheckBFS {

	  //Breadth First Traversal of Graph g 
	  public static String bfs(Graph g) {
	    String result = "";
	    Map<Integer,Boolean> visitedMap = new HashMap<>();
	    for(int i = 0; i < g.vertices; i++) {
	    	visitedMap.put(i, false);
	    }
	    Integer startVertex = 0;
	    Queue<Integer> queue = new Queue<>(g.vertices);
	    queue.enqueue(startVertex);
	    visitedMap.put(startVertex, true);
	    
	    while(queue.getCurrentSize() > 0) {
	    	int temp =  queue.dequeue();
	    	DoublyLinkedList list = g.adjacencyList[temp];
	    	while(!list.isEmpty()) {
	    		if(visitedMap.get(list.headNode) == false)
	    			queue.enqueue(list.headNode.data);
	    	}
	    }
	    return result; 
	  }

	}

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.printGraph();
		
		CheckBFS bfs = new CheckBFS();
		bfs.bfs(graph);
	}

}
