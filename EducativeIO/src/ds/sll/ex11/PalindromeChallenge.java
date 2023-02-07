package ds.sll.ex11;

/*
Find if a doubly linked-list is a palindrome.

Input:
	List = 2<->0<->0<->2
	List = 1<->2<->3<->2<->1
	List = 1<->2<->3
	List = 2<->3
Output:
	true
	true
	false
	false
 * */

public class PalindromeChallenge {
	public static <T> boolean isPalindrome(DoublyLinkedList<T> list) {
        String str1 = "";
        String str2 = "";
        
        DoublyLinkedList.Node start = list.getHeadNode();
        while(start != null) {
        	str1 += start.data;
        	start = start.nextNode;
        }
        
        DoublyLinkedList.Node end = list.getTailNode();
        while(end != null) {
        	str2 += end.data;
        	end = end.prevNode;
        }
        
        return str1.equalsIgnoreCase(str2);
    }
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.insertAtEnd(2);
		list.insertAtEnd(0);
		list.insertAtEnd(0);
		list.insertAtEnd(1);
		
		System.out.println(isPalindrome(list));
	}
}
