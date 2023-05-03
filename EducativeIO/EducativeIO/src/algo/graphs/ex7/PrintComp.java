package algo.graphs.ex7;

import java.util.*;

/*
Implement a function that takes an undirected graph and prints all the connected components of the graph.

Algorithm : For each new start vertex, print on a new line. Also, don't jump to a new line if there is 
			no traversal.

Input:
	graph = {
    0 -- 1
    1 -- 2
    3 -- 4
    5 -- 3
    5 -- 6
    3 -- 6
	}
	
Output:
	0 1 2
	3 4 5 6
	
 * */

public class PrintComp {
	 public static void printConnectedComponents(Graph g) {
		 
		    HashMap<Integer,Boolean> visitedMap = new HashMap<>();
		    for(int i = 0; i < g.getVertices(); i++) {
		    	visitedMap.put(i, false);
		    }
		    for(int startVertex = 0; startVertex < g.getVertices(); startVertex++) {
		    	String result = "";
		    	if(!visitedMap.get(startVertex)) {
		    		Queue<Integer> queue = new LinkedList<>();
		    		queue.add(startVertex);
		    		visitedMap.put(startVertex, true);
		    		while(!queue.isEmpty()) {
		    			int current = queue.poll();
		    			result += current+" ";
		    			LinkedList<Integer> tempList = g.getAdj()[current]; //for visiting connected node
		    			for(int i = 0; i < tempList.size(); i++) {
		    				if(!visitedMap.get(tempList.get(i))) {
		    					queue.add((Integer) tempList.get(i));
		    					visitedMap.put((Integer) tempList.get(i), true);
		    				}
		    			}
		    		}
		    	}
		    	if(!result.equals("")) { //prevent unnecessary extra space. All problems are like some version of traversal
		    		System.out.println(result);
		    	}
		    	
		    }
		    
		 }
	 
	 public static void main(String[] args) {
		 Graph g = new Graph(7);
		 g.addEdge(0,1);
		 g.addEdge(1,2);
		 g.addEdge(3,4);
		 g.addEdge(5,3);
		 g.addEdge(5,6);
		 g.addEdge(3,6);
		 
		 printConnectedComponents(g);
	 }
}