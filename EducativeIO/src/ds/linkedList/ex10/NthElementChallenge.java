package ds.linkedList.ex10;

/*
Implement Object nthElementFromEnd(SinglyLinkedList<T> list, int n) method, which will take a linked list as an input 
and returns the nth element of the list from the end.

Input:
	linkedlist = 22->18->60->78->47->39->99 and n=3
Output:
	47
 * */

public class NthElementChallenge {
	
	 public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
	        int fromFirst = list.getSize()-n+1;
	        int index = 1;
	        SinglyLinkedList.Node temp = list.getHeadNode();
	        while(temp != null) {
	        	if(index == fromFirst)
	        		return (Integer)temp.data;
	        	index++;
	        	temp = temp.nextNode;
	        }
	        return null;
	    }

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertAtEnd(22);
		list.insertAtEnd(18);
		list.insertAtEnd(60);
		list.insertAtEnd(78);
		list.insertAtEnd(47);
		list.insertAtEnd(39);
		list.insertAtEnd(99);
		System.out.println(nthElementFromEnd(list,3));
	}

}
