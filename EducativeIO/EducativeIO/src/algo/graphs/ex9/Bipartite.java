package algo.graphs.ex9;

/*
Input:
	Check if a graph is bipartite or not.

	graph =  {
	   0 -- 1 
       1 -- 2 
       2 -- 3 
       3 -- 4 
       4 -- 5 
       5 -- 0
       }
       
Output:
	true
	
Logic:  Color the unvisited child node with color other than that of parent and keep traversing. If while traversal
		we encountered the same color visited node, then the graph cannot be colored using 2 colors. Thus, the graph
		is not bipartite. 
 * */

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
	 public static Object isBipartite(Graph g, int source, boolean visited[], boolean color[]) {
		  Queue<Integer> queue = new LinkedList<Integer>();
		  visited[source] = true;
		  queue.add(source);
		  while(!queue.isEmpty()) {
			  int parent = queue.poll();
			  LinkedList<Integer> childList = g.getAdj()[parent]; //for visiting connected node
 			  for(int i = 0; i < childList.size(); i++) {
 				  int child = childList.get(i);
 				if(!visited[child]) { //unvisited node
 					color[child] = (color[parent] == true)? false : true; //color child different to that of parent
 					visited[child] = true;
 					queue.add(child);
 				}
 				else { //if a node is visited and has same color. Then coloring by 2 color is not feasible
 					if(color[child] == color[parent]) {
 						return false;
 					}
 				}
 			}
		  }
		  return true; //all nodes visited and colored
		 }
	 
	 public static void main(String[] args) {
		 int vertices = 6;
		 Graph g = new Graph(vertices);
		 g.addEdge(0,1);
		 g.addEdge(1,2);
		 g.addEdge(2,3);
		 g.addEdge(3,4);
		 g.addEdge(4,5);
		 g.addEdge(5,0);
		 
		 int source = 0;
		 boolean[] visited = new boolean[vertices];
		 boolean[] color = new boolean[vertices];
		 
		 System.out.println(isBipartite(g,source,visited,color));
	 }
}
