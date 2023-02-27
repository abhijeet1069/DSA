package ds.graphs.ex02;

import java.util.HashMap;
import java.util.Map;

/**
 Implement the DFS algorithm.
 Input:
    0
        1
            3
            4
        2
 Output:
    "01342"

 while(!stack.isEmpty()) {
    int temp = nextUnvisitedNode(g,map,stack.top()); //main line for dfs
    if(temp != -1) {
        stack.push(temp);
    }
    else {
        result += stack.pop()+" ";
    }
 }
 * */
public class CheckDFS {
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
    
    public static String dfs(Graph g) {
        String result = "";
        Map<Integer,Boolean> map = new HashMap<>(); //True - Visited, False = Unvisited
        for(int i = 0; i < g.vertices; i++){
            map.put(i,false);
        }
        
        for(int startVertex = 0 ; startVertex < g.vertices; startVertex++) { //check for all start vertex. What if there is a disconnected graph
        	Stack<Integer> stack = new Stack<>(g.vertices);
        	if(map.get(startVertex) == false) {
        		stack.push(startVertex);
        		map.put(startVertex, true);
        	}
        	while(!stack.isEmpty()) {
        		int temp = nextUnvisitedNode(g,map,stack.top()); //main line for dfs
        		if(temp != -1) {
        			stack.push(temp);
        		}
        		else {
        			result += stack.pop()+" ";
        		}
        	}
        }
        return result;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        //graph.printGraph();
        System.out.println(CheckDFS.dfs(graph));
    }
}