package ds.graphs.ex01;

import java.util.HashMap;
import java.util.Map;

/**
 Implement the breadth first search in JAVA.
 Input:
 	0
 		1
 			3
 			4
 		2
 Output:
 	"01234"
 * */

class CheckBFS {

	  //Breadth First Traversal of Graph g 
	  public static String bfs(Graph g) {
	    String result = "";
	    
	    //true - visited, false - not visited
	    Map<Integer,Boolean> visitedMap =  new HashMap<>();
	    for(int i = 0 ;i<g.vertices; i++) {
	    	visitedMap.put(i, false);
	    }
	    
	    for(int startVertex = 0 ;startVertex<g.vertices; startVertex++) {
	    	if(visitedMap.get(startVertex) == false) {
	    		Queue<Integer> queue = new Queue<>(g.vertices);
	    		queue.enqueue(startVertex);
	    		visitedMap.put(startVertex,true);
	    		while(!queue.isEmpty()) {
	    			int temp = queue.dequeue();
	    			result += temp;
	    			DoublyLinkedList.Node iterator = g.adjacencyList[temp].getHeadNode();
	    			while(iterator!=null) {
	    				if(visitedMap.get(iterator.data) == false) {
	    					queue.enqueue((Integer)iterator.data);
	    					visitedMap.put((Integer)iterator.data, true);
	    				}
	    				iterator = iterator.nextNode;
	    			}
	    		}
	    	}
	    }

	    return result; 
	  }

	}

public class Main{
	public static void main(String[] args) {
		Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        //graph.printGraph();
        System.out.println(CheckBFS.bfs(graph));
	}
}