package ds.sll.ex02;
/**
 Complete boolean searchNode(T data) which searches for a value in list.
 Input:
    list = 5->90->10->4
    value = 4
 Output:
    true
 **/
public class CheckSearch {
    public static void main(String args[]) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            sll.insertAtEnd(i);
        }

        if(sll.searchNode(3)) {   // Calling search function
            System.out.println("Value: 3 is Found");
        }
        else {
            System.out.println("Value: 3 is not Found");
        }

        if(sll.searchNode(15)) {   // Calling search function
            System.out.println("Value: 15 is Found");
        }
        else {
            System.out.println("Value: 15 is not Found");
        }
    }
}
