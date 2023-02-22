package ds.graphs.ex06;

/**
Implement checkPath() method to take a graph and two vertices as an input and find out if a path exists between them.
	Path - For a path to exist between any two vertices, there should be no repeated sequence of edges and vertices between the source and the destination vertex.

Input:
Graph:
	|0|->1->5->null
	|1|->2->3->null
	|2|->5->null
	|3|->null
	|4|->2->5->null
	|5|->6->7->3->null
	|6|->7->null
	|7|->null

source = 7;
destination = 0;

Output:
	false
	
Logic : DFS from source vertex and check if path contains destination vertex. 
 * */

import java.util.HashMap;
import java.util.Map;

public class CheckPaths {
    public static int nextUnvisitedNode(Graph g, Map<Integer,Boolean> map, int node){
        int res = -1;
        DoublyLinkedList<Integer> list = g.adjacencyList[node];
        DoublyLinkedList<Integer>.Node temp = list.getHeadNode();;
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
    public static boolean checkPath(Graph g, int source, int destination) {
        Map<Integer,Boolean> map = new HashMap<>(); //True - Visited, False = Unvisited
        for(int i = 0; i < g.vertices; i++){
            map.put(i,false);
        }

        Stack<Integer> stack = new Stack<>(g.vertices);
        stack.push(source);
        map.put(source,true);

            while(!stack.isEmpty()) {
                int temp = nextUnvisitedNode(g,map,stack.top());
                if(temp != -1) {
                    stack.push(temp);
                }
                else {
                    if(stack.pop() == destination){
                        return true;
                    }
                }
            }
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0,1);
        g.addEdge(0,5);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(4,2);
        g.addEdge(4,5);
        g.addEdge(2,5);
        g.addEdge(5,6);
        g.addEdge(5,7);
        g.addEdge(5,3);
        g.addEdge(6,7);

        g.printGraph();

        int source = 7;
        int destination = 0;
        System.out.println(checkPath(g,source,destination));
    }
}
