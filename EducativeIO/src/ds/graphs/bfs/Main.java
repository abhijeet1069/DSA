package ds.graphs.bfs;

import java.util.HashMap;
import java.util.Map;

import ds.graphs.bfs.Graph;

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