package algo.graphs.ex1;

import java.util.HashMap;

class CheckBFS {

  //Breadth First Traversal of Graph g 
  //Breadth First Traversal of Graph g 
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
