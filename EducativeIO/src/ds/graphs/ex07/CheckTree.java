package ds.graphs.ex07;

/**
Implement isTree() method to take a directed graph as an input and find out if it is a tree. 
A graph could only be a tree if:
	a) Each node, except root, has exactly one parent - Parent graph made by reversing vertices and finding degree.
	b) There are no cycles - If vertex visited is already present in stack. Then there is a cycle. Also, initially keep startVertex as unvisited. (Based on DFS)
	c) Graph is connected - Covered under exactly one parent. As unconnected node will have 0 parents

Also, remember the DFS logic which is crucial not only in traversal but also in problems of cycle detection, path existence between two vertices.

Input:
	|0|->1->3->2->null
	|1|->null
	|2|->null
	|3|->2->null

Output:
	false
 * */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CheckTree {

    public static Graph parentGraph(Graph g) {
        Graph pg = new Graph(g.vertices);
        for (int i = 0; i < pg.vertices; i++) {
            DoublyLinkedList list = g.adjacencyList[i];
            DoublyLinkedList.Node node = list.getHeadNode();
            while (node != null) {
                pg.addEdge((Integer) node.data, i); //reversal of edge
                node = node.nextNode;
            }
        }
        return pg;
    }

    //check one parent also checks whether graph is connected. As, disconnected node will have no parents
    public static boolean checkOneParentAndConnected(Graph g) {
        int rootNode = 0;
        int[] count = new int[g.vertices]; //count of parent
        for (int i = 0; i < g.vertices; i++) {
            DoublyLinkedList list = g.adjacencyList[i];
            DoublyLinkedList.Node node = list.getHeadNode();
            while (node != null) {
                count[i] = count[i] + 1;
                node = node.nextNode;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 1 && i != rootNode) {
                return false;
            }
        }
        return true;
    }

    public static int nextUnvisitedNode(Graph g, Map<Integer, Boolean> map, int node) {
        int res = -1;
        DoublyLinkedList<Integer> connectedNodes = g.adjacencyList[node];
        DoublyLinkedList<Integer>.Node temp = connectedNodes.getHeadNode();
        ;
        while (temp != null) {
            if (map.get(temp.data) == false) {
                res = temp.data;
                map.put(res, true); //node has been visited
                break;
            }
            temp = temp.nextNode;
        }
        return res;
    }

    public static boolean detectCycle(Graph g) {
        Map<Integer, Boolean> map = new HashMap<>(); //True - Visited, False = Unvisited
        for (int i = 0; i < g.vertices; i++) {
            map.put(i, false);
        }
        
        for(int startVertex = 0; startVertex < g.vertices; startVertex++) {
        	Stack<Integer> stack = new Stack<>(g.vertices);
            HashSet<Integer> set = new HashSet<>(g.vertices); //Logic : if a vertex already in stack then there is a cycle
            
            stack.push(startVertex);
            set.add(startVertex);
            
            while (!stack.isEmpty()) {
                int temp = nextUnvisitedNode(g, map, stack.top()); //main line for dfs
                if(set.contains(temp)){ //if any cycle detected for any vertex return
                    return true;
                }
                if (temp != -1) {
                    stack.push(temp);
                    set.add(temp);
                }
                else {
                    int visited =  stack.pop();
                    set.remove(visited);
                }
            }
        }
            return false;
        }
        
    public static boolean isTree(Graph g) {
        Graph pg = parentGraph(g);
        boolean isOneParent = checkOneParentAndConnected(pg); //assuming 0 is the root node
        boolean isCycle = detectCycle(g);
       // System.out.println(isCycle + " " + isOneParent);
        return isOneParent && !isCycle;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(0, 2);
        g.addEdge(3, 2);
        g.printGraph();
        System.out.println(isTree(g));
    }
}
