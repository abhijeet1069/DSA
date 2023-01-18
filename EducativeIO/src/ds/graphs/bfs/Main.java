package ds.graphs.bfs;

import java.util.HashMap;
import java.util.Map;

class CheckBFS {

	  //Breadth First Traversal of Graph g 
	  public static String bfs(Graph g) {
	    String result = "";

	    // Write - Your - Code

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
