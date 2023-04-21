package ds.tree.ex03;

/**
 Implement findAncestors() function to find the ancestor os the node with the value "k".
 	String findAncestors(Node root, int k);

 Sample Input
 	bst = {
 		6 -> 4,9
 		4 -> 2,5
 		9 -> 8,12
 		12 -> 10,14
 		}
 	k = 10

 Sample Output
 	6,9,12,
 * */

public class CheckAncestors {
	  public static String findAncestors(Node root, int k) {
		  Node temp = root;
		  String str = "";
		  
		  while(temp != null) {  
			  if(k > temp.getData()) {
				  str += temp.getData()+","; //first log data then move
				  temp = temp.rightChild;
			  }
			  else if(k < temp.getData()) {
				  str += temp.getData()+",";
				  temp = temp.leftChild;
			  }
			  else { //stop if node found
				  break;
			  }
			  
		  }
		  if(temp == null) { //whole tree traversed and no matching node found
			  return "";
		  }
		  else {
			  return str;
		  }
		  
		  }
	  
	  public static void main(String[] args) {
		  binarySearchTree bst = new binarySearchTree();
		  bst.add(6);
		  bst.add(4);
		  bst.add(9);
		  bst.add(4);
		  bst.add(2);
		  bst.add(5);
		  bst.add(9);
		  bst.add(8);
		  bst.add(12);
		  bst.add(12);
		  bst.add(10);
		  bst.add(14);
		  
		  bst.printTree(bst.getRoot());
		  
		  int k = 4;
		  System.out.println("Anestors of "+k+" are : "+findAncestors(bst.getRoot(),k));
	  }
}
