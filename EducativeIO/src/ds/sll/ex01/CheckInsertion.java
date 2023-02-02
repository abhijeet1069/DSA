package ds.sll.ex01;

/**
 Complete function insertAtEnd(T data). The function inserts data at the end of list
 Input:
    list = 0->1->2
    data = 3
 Output:
    list = 0->1->2->3
 * */

public class CheckInsertion {
    public static void main( String args[] ) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.printList();
        for (int i = 1; i <= 10; i++) {
            sll.insertAtEnd(i);
            sll.printList();
        }
    }
}
