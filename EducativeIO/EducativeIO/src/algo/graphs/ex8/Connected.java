package algo.graphs.ex8;

import java.util.*;

/*
Implement a function that takes a source vertex and a destination vertex as arguments and checks whether
 deleting the corresponding edge creates separate components in the directed graph.
 
Algorithm : If there is some traversal in string for each start vertex. increment counter for each component.
			Check if counter > 1
 
Input:
	graph { 
		0 -> 1
        0 -> 2
        2 -> 3
        2 -> 4
        4 -> 0
        }
    source = 0 destination = 1
        
Output:
	true
	
 * */

public class Connected{
	  public static boolean isConnected(Graph g) {
		    //use this helper function if you want to
		  return false;
		}

		public static Object willCauseSeparateComponents(Graph g, int source, int destination) {
				g.removeEdge(source, destination);
				int counter = 0;
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
			    		counter++;
			    	}
			    	
			    }
			    return counter > 1; //If counter is > 1 then the graph has separate components
			}
		
		public static void main(String[] args) {
			Graph g = new Graph(5);
			g.addEdge(0, 0);
			g.addEdge(0,1);
			g.addEdge(0,2);
			g.addEdge(2,3);
			g.addEdge(2,4);
			g.addEdge(4,0);
			
			System.out.println(willCauseSeparateComponents(g,0,1));
		}
		}