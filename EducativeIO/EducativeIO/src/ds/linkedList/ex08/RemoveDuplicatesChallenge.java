package ds.linkedList.ex08;

/*
 You have to implement public static <T> void removeDuplicates(SinglyLinkedList<T> list) method, which 
 will take a Singly linked list as input and remove all the elements that appear more than once in the list.
 
 Input:
 	7->14->21->14->22->null
 Output:
 	7->14->21->22->null
 * */

import java.util.HashSet;

public class RemoveDuplicatesChallenge {

	public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
        HashSet<Integer> set = new HashSet<>();
        SinglyLinkedList.Node currPtr = list.headNode;
        SinglyLinkedList.Node prevPtr = list.headNode;
        while(currPtr != null) {
        	if(set.contains(currPtr.data)) {
        		prevPtr.nextNode = currPtr.nextNode;
        		currPtr = prevPtr;
        	}
        	else {
        		set.add((Integer)currPtr.data);
        	}
        	prevPtr = currPtr;
        	currPtr = currPtr.nextNode;
        }
    }
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertAtEnd(7);
		list.insertAtEnd(14);
		list.insertAtEnd(21);
		list.insertAtEnd(14);
		list.insertAtEnd(22);
		list.printList();
		removeDuplicates(list);
		list.printList();
	}

}
