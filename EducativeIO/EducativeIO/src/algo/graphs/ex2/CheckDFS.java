package algo.graphs.ex2;

import java.util.HashMap;

/*
Implement depth first search traversal.

Input:
	The input is a graph in the form of an adjacency list.
	|V|=5, E:[(0,1)(0,2)(1,3)(1,4)], where, |V| = Number of vertices and E = edges.
	
Output:
	"01342"
 * */

class CheckDFS {
    //Depth First Traversal of Graph g 
    public static String dfs(Graph g) {
    	String result = "";
	    HashMap<Integer,Boolean> visitedMap = new HashMap<>();
	    for(int i = 0; i < g.vertices; i++) {
	    	visitedMap.put(i, false);
	    }
	    for(int startVertex = 0; startVertex < g.vertices; startVertex++) { //In-case, graph is disconnected, it could multiple start vertices
	    	if(!visitedMap.get(startVertex)) {
	    		Stack<Integer> stack = new Stack<>(g.vertices); //DFS is same as BFS. Only instead of queue we are using a stack
	    		stack.push(startVertex);
	    		visitedMap.put(startVertex, true);
	    		while(!stack.isEmpty()) {
	    			int current = stack.pop();
	    			result += current;
	    			DoublyLinkedList.Node node = g.adjacencyList[current].headNode; //for visiting connected node
	    			while(node != null) {
	    				if(!visitedMap.get(node.data)) {
	    					stack.push((Integer) node.data);
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
    	System.out.println(dfs(g));
    	
    }
}