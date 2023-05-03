package algo.graphs.ex8;

import java.io.*;
import java.util.*;

public class Graph {
 private int vertices; //number of vertices 
 private LinkedList < Integer > adjacencyList[]; //Adjacency Lists 
 @SuppressWarnings("unchecked")
 // Constructor 
 Graph(int vert) {
  this.vertices = vert;
  this.adjacencyList = new LinkedList[vertices];
  for (int i = 0; i < this.vertices; ++i)
   this.adjacencyList[i] = new LinkedList();
 }

 // Function to add an edge into the graph 
 void addEdge(int source, int destination) {
  this.adjacencyList[source].add(destination);
  //for undirected graph edge added from destination to source as well
  this.adjacencyList[destination].add(source);
 }

 void removeEdge(int source, int destination) {
  this.adjacencyList[source].removeFirstOccurrence(destination);
  //for undirected graph edge added from destination to source as well
  this.adjacencyList[destination].removeFirstOccurrence(source);
 }

 public int getVertices() {
  return this.vertices;
 }

 public LinkedList < Integer > [] getAdj() {
  return this.adjacencyList;
 }


 public void dfsTraversal(int v, boolean visited[]) {
  visited[v] = true;
  int source = 0;


  Iterator < Integer > i = adjacencyList[v].iterator();
  Integer temp;
  while (i.hasNext()) {
   temp = i.next();
   if (!visited[temp])
    dfsTraversal(temp, visited);
  }
 }
};
