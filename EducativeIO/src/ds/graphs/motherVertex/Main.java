package ds.graphs.motherVertex;

import java.util.HashMap;
import java.util.Map;

import ds.graphs.motherVertex.DoublyLinkedList;
import ds.graphs.motherVertex.Graph;
import ds.graphs.motherVertex.Stack;

public class Main {
	
	//return unvisited member of map
    public static int nextUnvisitedNode(Graph g, Map<Integer,Boolean> map, int node){
        int res = -1;
        DoublyLinkedList<Integer> connectedNodes = g.adjacencyList[node];
    	DoublyLinkedList<Integer>.Node temp = connectedNodes.getHeadNode();; 
        while(temp != null) {
        	if(map.get(temp.data) == false) {
        		res = temp.data;
        		map.put(res,true); //node has been visited
        		break;
        	}
        	temp = temp.nextNode;
        }
        return res;
    }
    
    public static int dfs(Graph g,int startVertex) {
        String result = "";
        Map<Integer,Boolean> map = new HashMap<>(); //True - Visited, False = Unvisited
        for(int i = 0; i < g.vertices; i++){
            map.put(i,false);
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>(g.vertices);
        if(map.get(startVertex) == false) {
        	stack.push(startVertex);
        	map.put(startVertex, true);
        }
        while(!stack.isEmpty()) {
        	int temp = nextUnvisitedNode(g,map,stack.top());
        	if(temp != -1) {
        		stack.push(temp);
        	}
        	else {
        		stack.pop();
				res++;
        		}
        	}
        return res;
    }
    
	 public static int findMotherVertex(Graph g){
		for(int i = 0; i < g.vertices; i++){
				if(dfs(g,i) == g.vertices)
					return i;
			}
		    return -1;
		  }
	 
	 public static void main(String[] args) {
		 int vertices = 4;
		 Graph g = new Graph(vertices);
		 g.addEdge(3, 0);
		 g.addEdge(3, 1);
		 g.addEdge(0, 1);
		 g.addEdge(1, 2);
		 //g.printGraph();
		 System.out.println(findMotherVertex(g));
	 }
}
