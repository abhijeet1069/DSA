package algo.graphs.ex1;

import java.util.HashMap;

class CheckBFS {

/*
Implement depth first search traversal.

Input:
	The input is a graph in the form of an adjacency list.
	|V|=5, E:[(0,1)(0,2)(1,3)(1,4)], where, |V| = Number of vertices and E = edges.
	
Output:
	"01234"
 * */	
	
	  public static String bfs(Graph g) {
	    String result = "";
	    HashMap<Integer,Boolean> visitedMap = new HashMap<>();
	    for(int i = 0; i < g.vertices; i++) {
	    	visitedMap.put(i, false);
	    }
	    for(int startVertex = 0; startVertex < g.vertices; startVertex++) { //In-case, graph is disconnected, it could multiple start vertices
	    	if(!visitedMap.get(startVertex)) {
	    		Queue<Integer> queue = new Queue<>(g.vertices);
	    		queue.enqueue(startVertex);
	    		visitedMap.put(startVertex, true);
	    		while(!queue.isEmpty()) {
	    			int current = queue.dequeue();
	    			result += current;
	    			DoublyLinkedList.Node node = g.adjacencyList[current].headNode; //for visiting node connected to a node. Represented by DoublyLinkedList
	    			while(node != null) {
	    				if(!visitedMap.get(node.data)) {
	    					queue.enqueue((Integer) node.data);
	    					visitedMap.put((Integer) node.data, true);
	    					node = node.nextNode;
	    				}
	    			}
	    		}
	    	}
	    }
	    return result; 
	  }
	  
	  public static void main(String[] args) {
		  int vertices = 5;
		  Graph g = new Graph(vertices);
		  g.addEdge(0, 1);
		  g.addEdge(0, 2);
		  g.addEdge(1, 3);
		  g.addEdge(1, 4);
		  //g.printGraph();
		  System.out.println(bfs(g));
	  }
}
