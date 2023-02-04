package ds.sll.ex4;

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
