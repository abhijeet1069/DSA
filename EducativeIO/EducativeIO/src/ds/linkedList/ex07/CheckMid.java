package ds.linkedList.ex07;

/*
You have to implement the public static <T> Object findMiddle(SinglyLinkedList<T> list) method, 
which will take a linked list as an input and return the value at the middle node of the list.

Input:
	linkedList = 7->14->10->21
Output:
	mid = 14
 * */

class CheckMid {
    public static void main( String args[] ) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.insertAtEnd(7);
        list.insertAtEnd(14);
        list.insertAtEnd(10);
        list.insertAtEnd(21);
        list.insertAtEnd(61);
        list.printList();
        System.out.println("Middle element is : " + findMiddle(list));
    }
    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        SinglyLinkedList.Node rabbit =  list.headNode; //rabbit is twice as fast as turtle
        SinglyLinkedList.Node turtle = list.headNode;
        while(rabbit != null) {
        	if(rabbit.nextNode != null && rabbit.nextNode.nextNode != null) {
        		rabbit = rabbit.nextNode.nextNode;
        	}
        	else {
        		break;
        	}
        	turtle = turtle.nextNode;
        }
        return turtle.data;
    }
}
