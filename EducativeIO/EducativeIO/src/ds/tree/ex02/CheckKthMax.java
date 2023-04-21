package ds.tree.ex02;

import java.util.ArrayList;

/**
 Implement the findKthMax() to take a BST and any number "k" as input, and return kth max number from that tree.
 	int findKthMax(Node root, int k);
 Sample Input
 	bst = {
 		6 -> 4,9
 		4 -> 2,5
 		9 -> 8,12
 		12 -> 10,14
 	}
 	k = 3

 	Sample Output
 		10

 Core Logic : Move rightward and insert elements in list in ascending order.
 * */

public class CheckKthMax {

	public static int findKthMax(Node root, int k) {

		Node temp = root;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(temp != null) {
			if(temp.leftChild != null) {
				list.add(temp.leftChild.getData()); //first add left node
			}
			list.add(temp.getData()); //then add current node
			temp = temp.rightChild; //move rightward for max
		}
		return list.get(list.size()-k);
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
		
		int k = 3;
		System.out.println(k+" max : "+findKthMax(bst.getRoot(), k));
	}
}
