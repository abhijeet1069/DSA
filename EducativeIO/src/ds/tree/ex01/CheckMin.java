package ds.tree.ex01;
/**
 Implement findMin() to return the min integer value from the given BST.
 	int findMin(Node root);

 Sample Input
 	bst = {
 		6 -> 4,9
 		4 -> 2,5
 		9 -> 8,12
 		12 -> 10,14
 }
 Sample Output
 	2
 * */

public class CheckMin 
{
	public static int findMin(Node root) 
  {
		Node temp = root;
		int res = Integer.MIN_VALUE;
		while(temp != null) {
			res = temp.getData();
			temp = temp.leftChild;
		}
		return res;
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
		
		System.out.println("Min Node = "+findMin(bst.getRoot())); //min node should be in extreme left
	}
}
