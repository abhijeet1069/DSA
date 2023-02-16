package ds.graphs.ex05;

public class CheckNumEdges {
    public static int numEdges(Graph g) {
        int count = 0;
        for(int i = 0; i < g.vertices; i++){
            DoublyLinkedList.Node temp = g.adjacencyList[i].getHeadNode();
            while(temp != null){
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
