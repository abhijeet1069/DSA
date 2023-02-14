package ds.graphs.test.representation;

import java.util.LinkedList;

/*
Graph Representation:
 	Adjacency Matrix : Best suited for edge operations
 	Adjacency List : Best suited for vertices operation

Bipartite graph : Graph that can be colored using 2 colors
 * */
class Graph{
	int vertices;
	LinkedList<Integer> adjacencyList[];
	
	Graph(int vertices){
		this.vertices = vertices;
		this.adjacencyList = new LinkedList[this.vertices];
		for(int i = 0 ; i < vertices; i++) {
			this.adjacencyList[i] = new LinkedList<>();
			adjacencyList[i].add(null);
		}
	}
	
	void printGraph() {
		for(int i = 0 ; i < this.adjacencyList.length; i++) {
			System.out.print(i+"->");
			for(int j = 0; j < this.adjacencyList[i].size(); j++) {
				Integer term = this.adjacencyList[i].get(j);
				if(term != null)
					System.out.print(this.adjacencyList[i].get(j)+"->");
				else
					System.out.print("null");
			}
			System.out.println();
		}
	}
	
	void addEdge(int source, int destination) {
		//add one position before null
		this.adjacencyList[source].add(this.adjacencyList[source].size()-1,destination);
	}
}


public class AdjacencyList {

	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.printGraph();
		
	}

}
