package algo.graphs.ex6;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

/*
Implement a function that tells us whether a directed graph is strongly connected or not.

Algorithm: For every vertex in graph check, whether we can traverse the whole graph or not.

Input:
	graph = {
    0 -> 1
    1 -> 2
    2 -> 3
    3 -> 0
    2 -> 4
    4 -> 2
	}
	
Output:
	true
 * */

public class StronglyConnected {
	//Breadth First Traversal of Graph g 
	  public static String bfs(Graph g, int startVertex) {
	    String result = "";
	    HashMap<Integer,Boolean> visitedMap = new HashMap<>();
	    for(int i = 0; i < g.getVertices(); i++) {
	    	visitedMap.put(i, false);
	    }
	    	if(!visitedMap.get(startVertex)) {
	    		Queue<Integer> queue = new LinkedList<>();
	    		queue.add(startVertex);
	    		visitedMap.put(startVertex, true);
	    		while(!queue.isEmpty()) {
	    			int current = queue.poll();
	    			result += current;
	    			LinkedList<Integer> tempList = g.getAdj()[current]; //for visiting connected node
	    			for(int i = 0; i < tempList.size(); i++) {
	    				if(!visitedMap.get(tempList.get(i))) {
	    					queue.add((Integer) tempList.get(i));
	    					visitedMap.put((Integer) tempList.get(i), true);
	    				}
	    			}
	    		}
	    	}
	    return result; 
	  }


	 public static Object isStronglyConnected(Graph g) {
		 //will work for only 10 vertices graph
		 for(int i = 0 ; i < g.getVertices(); i++) {
			 if(bfs(g,i).length() != g.getVertices()) { //If I am on a given start vertex. Am I able to traverse whole graph
				 return false;
			 }
		 }
		return true;
	 	}
	 
	 public static void main(String[] args) {
		 Graph g = new Graph(5);
		 g.addEdge(0,1);
		 g.addEdge(1,2);
		 g.addEdge(2,3);
		 g.addEdge(3,0);
		 g.addEdge(2,4);
		 g.addEdge(4,2);
		 
		 System.out.println(isStronglyConnected(g));
	 }
}
