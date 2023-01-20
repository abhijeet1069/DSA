package ds.graphs.bfs;

import java.util.HashMap;

class CheckBFS {

	//Breadth First Traversal of Graph g
	public static String bfs(Graph g) {
		String result = "";
		boolean[] visitedMap = new boolean[g.vertices];
		for(int startVertex = 0; startVertex < g.vertices; startVertex++) {
			if(!visitedMap[startVertex])
				result += bfsTraverse(g, startVertex, visitedMap);
		}
		return result;
	}

	public static String bfsTraverse(Graph graph, int start, boolean[] visitedMap){
		String result = "";
		Queue<Integer> queue = new Queue<>(graph.vertices);
		queue.enqueue(start);
		visitedMap[start] = true;
		while(!queue.isEmpty()){
			int current_node = queue.dequeue();
			result += current_node;

			DoublyLinkedList.Node temp = null;
			if(graph.adjacencyList[current_node] != null)
				temp = graph.adjacencyList[current_node].headNode;

			while(temp != null){
				if(visitedMap[(int)temp.data] == false){
					queue.enqueue((int)temp.data);
					visitedMap[(int)temp.data] = true;
				}
				temp = temp.nextNode;
			}

		}
		return result;
	}
}

public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(1,3);
		graph.addEdge(1,4);

		System.out.println(CheckBFS.bfs(graph));
	}
}