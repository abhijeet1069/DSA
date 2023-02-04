package ds.sll.ex7;

class CheckMid {
    public static void main( String args[] ) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.insertAtEnd(1);
        list.insertAtEnd(2);

        list.insertAtEnd(123);
        list.insertAtEnd(101);
        list.insertAtEnd(61);
        list.printList();
        System.out.println("Middle element is : " + findMiddle(list));
    }
    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        // Write -- Your -- Codeteams

        return -1;
    }
}
