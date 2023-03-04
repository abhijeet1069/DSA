package ds.tree.ex05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CheckKNodes {
	public static String findKNodes(Node root, int k) {
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
		
			}
			if(temp.rightChild != null) {
				queue.add(temp.rightChild);
				int level = map.get(temp.getData())+1;
				map.put(temp.rightChild.getData(), level);
			}
		} //level of node set in HashMap
		
		String str = "";
		for(int x : map.keySet()) {
			if(map.get(x) == k) {
				str += x+",";
			}
		}
		
		return str;
	}
}
