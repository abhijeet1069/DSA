package ds.graphs.ex07;

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

    public static boolean isTree(Graph g) {
        Graph pg = parentGraph(g);
        System.out.println("Parent Graph");
        pg.printGraph();

        boolean isOneParent = checkOneParentAndConnected(pg); //assuming 0 is the root node
        return isOneParent;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(0,2);
        g.addEdge(3,2);

        System.out.println(isTree(g));
    }
}
