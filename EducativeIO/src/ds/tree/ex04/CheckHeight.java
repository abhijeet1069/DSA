package ds.tree.ex04;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 Implement the findHeight() function to find the height of a given BST.
 	Height of a Node — Maximum number of connections between the node and a leaf node in its path.
 	Height of a Tree — Height of its root node.
 	int findHeight(Node root);

 Sample Input:
 	bst = { //here 6 is the root
 		6 -> 4,9
 		4 -> 2,5
 		9 -> 8,12
 		12 -> 10,14
 	}
 Sample Output:
 		3
 * */

public class CheckHeight {

	public static int findHeight(Node root) {
		int max = 0;
		Queue<Node> queue = new LinkedList<>();
		HashMap<Integer,Integer> map= new HashMap<>();
		queue.add(root);
		map.put(root.getData(), 0); //root has 0 depth, also assuming all node data are unique in bst
		while(!queue.isEmpty()) {
			Node temp = queue.remove();
			if(temp.leftChild != null) {
				queue.add(temp.leftChild);
				int level = map.get(temp.getData())+1;
				map.put(temp.leftChild.getData(), level); //depth of parent+1
				max = Math.max(max, level);
			}
			if(temp.rightChild != null) {
				queue.add(temp.rightChild);
				int level = map.get(temp.getData())+1;
				map.put(temp.rightChild.getData(), level);
				max = Math.max(max, level);
			}
		}
		return max;
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
		
		//bst.printTree(bst.getRoot());
		
		System.out.println("Height ="+findHeight(bst.getRoot()));
	}
}
