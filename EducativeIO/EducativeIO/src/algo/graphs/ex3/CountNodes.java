package algo.graphs.ex3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
Implement a function that returns the number of nodes at a given level of an undirected graph.

Sample Input:
	graph {
	   0 - 1
       0 - 2
       1 - 3
       2 - 3
       3 - 5
       2 - 4
	}
	
Sample Output:
	1
 * */

class CountNodes {
  public static int numberOfNodesInGivenLevel(Graph g, int source, int level) {
		  int count = 0; //count initialized to zero
		  //int num_of_vertices = g.getVertices(); //getVertices given in Graph.java file
		  HashMap<Integer,Integer> map = new HashMap<>(); //map<node,level of node>
		  Queue<Integer> queue = new LinkedList<>();
		  map.put(source, 1); //level of source vertex is 1
		  queue.add(source);
		  while(!queue.isEmpty()) {
			  int parent = queue.poll();
			  LinkedList<Integer> list = g.getAdj()[parent];
			  for(int i = 0; i < list.size(); i++) {
				  queue.add(list.get(i));
				  map.put(list.get(i), map.get(parent)+1); //level of a node = level of its parent+1
			  }
		  }
		  for(int i : map.keySet()) {
			  if(level == map.get(i)) {
				  count++;
			  }
		  }
		  return count;
		 }
  
  public static void main(String[] args) {
	  Graph g = new Graph(6);
	  g.addEdge(0,1);
	  g.addEdge(0,2);
	  g.addEdge(1,3);
	  g.addEdge(2,3);
      g.addEdge(3,5);
	  g.addEdge(2,4);
	  
	  System.out.println(numberOfNodesInGivenLevel(g,0,1));
  }
}
