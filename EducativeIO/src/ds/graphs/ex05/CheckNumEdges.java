package ds.graphs.ex05;

/**
 Implement numEdges(Graph g) method to find total number of edges in graph.
 Input:
 |0|->1->4->null
 |1|->0->2->3->null
 |2|->1->4->5->null
 |3|->1->5->null
 |4|->0->2->5->null
 |5|->4->2->6->7->3->null
 |6|->5->7->null
 |7|->5->6->null
 	
 Output:
 Edges : 11
 * */

public class CheckNumEdges {
    public static int numEdges(Graph g) {
        int count = 0;
        for(int i = 0; i < g.vertices; i++){
            DoublyLinkedList.Node temp = g.adjacencyList[i].getHeadNode();
            while(temp != null){ //inbuilt data structure used
                count++;
                temp = temp.nextNode;
            }
        }
        return count/2;
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0,1);
        g.addEdge(0,4);
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

        System.out.println("Edges : "+numEdges(g));
    }
}
