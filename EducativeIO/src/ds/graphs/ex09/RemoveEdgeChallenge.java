package ds.graphs.ex09;

class RemoveEdgeChallenge {
    public static void removeEdge(Graph g, int source, int destination) {
        DoublyLinkedList.Node currentNode = g.adjacencyList[source].getHeadNode();
        DoublyLinkedList.Node prevNode = null;
        while(currentNode != null){
            if((int)currentNode.data == destination){
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        if(currentNode == null){ //end of list reached and no match found or the list is empty
            return;
        }
        else{
            if(prevNode == null){ //Case 1 : Deletion at head
                g.adjacencyList[source].headNode = g.adjacencyList[source].headNode.nextNode;
            }
            else{ //Case 2 : Deletion in between
                prevNode.nextNode = currentNode.nextNode;
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(3,4);

        g.printGraph();

        removeEdge(g,3,2);
        g.printGraph();
    }
}
