package algo.graphs.ex4;

import java.util.LinkedList;

/*
Implement a function that takes a directed graph as input and print its transpose.

Input:
	graph = {
    0 -> 2
    0 -> 1
    1 -> 4
    1 -> 3}
    
Output:
	4-->1 
	3-->1
	1-->0 
	2-->0
 * */

public class Transpose {
	 
	public static void getTranspose(Graph g) {
		  Graph transposedGraph = new Graph(g.getVertices()); //new graph to store the transpose
		  for(int i = 0 ; i < g.getAdj().length; i++) {
			  LinkedList<Integer> list = g.getAdj()[i];
			  for(int j = 0; j < list.size(); j++) {
				  transposedGraph.addEdge(list.get(j), i);
			  }
		  }
		  //g.setVertices(transposedGraph.getVertices());
		  //g.setAdjacencyList(transposedGraph.getAdj());
		  transposedGraph.printGraph(); //calling print function on the final transposed graph
		 }
	 
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0,2);
		g.addEdge(0,1);
		g.addEdge(1,4);
		g.addEdge(1,3);
		
		getTranspose(g);
	}
}
