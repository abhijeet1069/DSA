package ds.linkedList.ex04;

/*
Implement the method int length(), which counts number of nodes in a linked list.
Input:
	linkedList = 0->1->2->3->4
Output:
	length = 5
 * */

public class CheckLength {
    public static void main( String args[] ) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.insertAtEnd("Betty");
        list.insertAtEnd("bought");
        list.insertAtEnd("some");
        list.insertAtEnd("butter");

        list.printList();
        System.out.println("Length : " + list.length());
    }
}
