package ds.sll.ex08;

public class RemoveDuplicatesChallenge {

	public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
        // Write -- Your -- Code
    }
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertAtEnd(7);
		list.insertAtEnd(14);
		list.insertAtEnd(21);
		list.insertAtEnd(14);
		list.insertAtEnd(22);
		list.printList();
	}

}
