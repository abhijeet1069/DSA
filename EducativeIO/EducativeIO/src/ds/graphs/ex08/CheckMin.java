package ds.graphs.ex08;

/*
 Given a graph, find the shortest path between two vertices.
 Sample Input
    graph =
        {
            0 -- 1, 0 -- 2, 0 -- 3
            3 -- 5, 5 -- 4, 2 -- 4
        }
 Vertex A = 0
 Vertex B = 4

 Sample Output
 2

 Main logic is to find vertices level using BFS. And then find min level of connected node to destination + 1
 StartVertex = 3
 Level Map = {0=1, 1=2, 2=2, 3=0, 4=2, 5=1}
 * */

import java.util.HashMap;
import java.util.Map;

public class CheckMin {
    public static int findShortestPathLength(Graph g, int source, int destination) {
        HashMap<Integer,Integer> levelMap = new HashMap<>();
        //true - visited, false - not visited
        Map<Integer,Boolean> visitedMap =  new HashMap<>();
        for(int i = 0 ;i<g.vertices; i++) {
            visitedMap.put(i, false);
        }
        levelMap.put(source,0);

            if(visitedMap.get(source) == false) {
                Queue<Integer> queue = new Queue<>(g.vertices);
                queue.enqueue(source);
                visitedMap.put(source,true);
                while(!queue.isEmpty()) {
                    int temp = queue.dequeue();
                    DoublyLinkedList.Node iterator = g.adjacencyList[temp].getHeadNode();
                    while(iterator!=null) {
                        if(visitedMap.get(iterator.data) == false) {
                            queue.enqueue((Integer)iterator.data);
                            visitedMap.put((Integer)iterator.data, true);
                            levelMap.put((Integer)iterator.data , levelMap.get(temp)+1);
                        }
                        iterator = iterator.nextNode;
                    }
                }
            }


        DoublyLinkedList.Node tempNode = g.adjacencyList[destination].getHeadNode();
        int min = Integer.MAX_VALUE;
        while(tempNode != null){
            min = Math.min(min, levelMap.get(tempNode.data));
            tempNode = tempNode.nextNode;
        }

        System.out.println(levelMap);
        return min+1;
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(3,5);
        g.addEdge(5,4);
        g.addEdge(2,4);

        g.printGraph();

        System.out.println("Min Length: "+findShortestPathLength(g,3,4));
    }
}
