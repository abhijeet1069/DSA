package ds.graphs.bfs;

import java.util.HashMap;

class CheckBFS {

	public static String bfs(Graph g) {
		String result = "";
		result += 0;
		boolean[] visitedMap = new boolean[g.vertices];
		for(int startVertex = 0; startVertex < g.vertices; startVertex++) {
			result += bfsTraverse(g, startVertex, visitedMap);
		}
		return result;
	}

	public static String bfsTraverse(Graph graph, int start, boolean[] visitedMap){
		String result = "";
		DoublyLinkedList<Integer> list = graph.adjacencyList[start];
		DoublyLinkedList.Node node = list.getHeadNode();
		while(node != null){
			if(visitedMap[(int)node.data] == false){
				visitedMap[(int)node.data] = true;
				result += (int)node.data;
			}
			node = node.nextNode;
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