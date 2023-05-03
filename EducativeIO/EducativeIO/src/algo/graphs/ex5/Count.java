package algo.graphs.ex5;

import java.util.LinkedList;
import java.util.Queue;

/*
Implement a function that counts all the paths that exist between two nodes (source to destination) of an acyclic (not containing cycles) directed graph.

Algorithm:	BFS from start vertex and check whether we land to the same vertex. if yes, then its a path.
			All exercises are some versions of BFS and DFS. Only at last 'color' is a new concept which is added.

Input:
	graph = {
    	0 -> 1
    	1 -> 2
    	1 -> 5
    	2 -> 3
    	2 -> 4
    	5 -> 3
    	5 -> 6
    	3 -> 6
	}
	source = 0
	destination = 6
	
Output:
	3

 * */

class Count {

	 public static int countPaths(Graph g, int start, int destination) {
			int count = 0;  //bfs not only covers all vertices but all paths too
			  Queue<Integer> queue = new LinkedList<>();
			  queue.add(start);
			  while(!queue.isEmpty()) {
				  int current = queue.poll();
				  //System.out.println(current);
				  if(current == destination) {
					  count++;
				  }
				  LinkedList<Integer> tempList = g.getAdj()[current];
				 for(int i = 0; i < tempList.size(); i++) {
					 queue.add(tempList.get(i));
				 }
				  
			  }
			  return count;
			 }
	 
	 public static void main(String[] args) {
		 Graph g = new Graph(7);
		 g.addEdge(0,1);
		 g.addEdge(1,2);
		 g.addEdge(1,5);
		 g.addEdge(2,3);
		 g.addEdge(2,4);
		 g.addEdge(5,3);
		 g.addEdge(5,6);
		 g.addEdge(3,6);
		 
		 int source = 0;
		 int destination = 6;
		 System.out.println(countPaths(g,source,destination));

	 }
	}
