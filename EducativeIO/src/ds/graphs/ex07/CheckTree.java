package ds.graphs.ex07;

import java.util.HashMap;
import java.util.Map;

public class CheckTree {

    public static Graph parentGraph(Graph g){
        Graph pg = new Graph(g.vertices);
        for(int i = 0;i < pg.vertices; i++){
            DoublyLinkedList list = g.adjacencyList[i];
            DoublyLinkedList.Node node = list.getHeadNode();
            while(node != null){
                pg.addEdge((Integer) node.data,i); //reversal of edge
                node = node.nextNode;
            }
        }
        return pg;
    }

    //check one parent also checks whether graph is connected. As, disconnected node will have no parents
    public static boolean checkOneParentAndConnected(Graph g){
        int rootNode = 0;
        int[] count = new int[g.vertices]; //count of parent
        for(int i = 0; i < g.vertices; i++){
            DoublyLinkedList list = g.adjacencyList[i];
            DoublyLinkedList.Node node = list.getHeadNode();
            while(node != null){
                count[i] = count[i]+1;
                node = node.nextNode;
            }
        }
        for(int i = 0; i < count.length; i++){
            if(count[i] != 1 && i != rootNode){
                return false;
            }
        }
        return true;
    }

    public static int lastVertex(Graph g, int startVertex) {
        int lastVertex = -1;
        Map<Integer,Boolean> visitedMap = new HashMap<>();
        for(int i = 0; i < g.vertices; i++) {
            visitedMap.put(i, false);
        }
        DoublyLinkedList.Node tempNode = g.adjacencyList[startVertex].getHeadNode();

        while(tempNode != null) { //last node is last visited node
            lastVertex = (int) tempNode.data;
            if(visitedMap.get(tempNode.data) == true){
                break;
            }
            visitedMap.put((Integer) tempNode.data, true);
            tempNode = tempNode.nextNode;
        }
        return lastVertex;
    }

    public static boolean detectCycle(Graph g){
        for(int  startVertex = 0; startVertex < g.vertices; startVertex++) {
            int lastVertex = lastVertex(g,startVertex);
            if(startVertex == lastVertex) {
                return true;
            }
        }
        return false;
    }
    public static boolean isTree(Graph g) {
        Graph pg = parentGraph(g);
        System.out.println("Parent Graph");
       // pg.printGraph();

        boolean isOneParent = checkOneParentAndConnected(pg); //assuming 0 is the root node
        g.printGraph();
        boolean isConnected = detectCycle(g);
        System.out.println(isConnected+" "+isOneParent);
        return isOneParent && !isConnected;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(2,0);
        g.addEdge(3,2);
        g.printGraph();
        System.out.println(isTree(g));
    }
}
