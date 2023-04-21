package ds.linkedList.ex09;

/*
Implement two methods, i.e., SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) and
 SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2).

The first method will take two linked lists as input and return the union of the two lists. 
A Union of two sets can be expressed as, “Union of two sets A and B is a set which contains all the elements present in A or B”.

Similarly, the second method will return the Intersection of two lists. 
The Intersection is commonly defined as, “A set which contains all the elements present in A and B”.

Input:
	list1 = 15->22->8->null
	list2 = 7->14->22->null
Output:
	Union = 15->22->8->7->14->null
	Intersection = 22->null
 * */

import java.util.HashMap;

public class CheckUnionIntersection {
    //performs union of two lists
	public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<Integer> result = new SinglyLinkedList<>();
        
        SinglyLinkedList.Node temp = list1.getHeadNode();
        while(temp != null) {
        	result.insertAtEnd((Integer) temp.data);
        	temp = temp.nextNode;
        }
        
        temp = list2.getHeadNode();
        while(temp != null) {
        	result.insertAtEnd((Integer) temp.data);
        	temp = temp.nextNode;
        }
        
        result.removeDuplicatesWithHashing();
        return (SinglyLinkedList<T>) result;
    }
    
    //performs intersection between list
    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<Integer> tempList = new SinglyLinkedList<>();
        
        list1.removeDuplicatesWithHashing();
        list2.removeDuplicatesWithHashing();
        
        
        SinglyLinkedList.Node temp = list1.getHeadNode();
        while(temp != null) {
        	tempList.insertAtEnd((Integer) temp.data);
        	temp = temp.nextNode;
        }
        
        temp = list2.getHeadNode();
        while(temp != null) {
        	tempList.insertAtEnd((Integer) temp.data);
        	temp = temp.nextNode;
        }
        
       HashMap<Integer,Integer> map = new HashMap<>();
       temp = tempList.getHeadNode();
       while(temp != null) {
    	   map.put((Integer) temp.data, map.getOrDefault(temp.data, 0)+1);
    	   temp = temp.nextNode;
       }
       
       SinglyLinkedList<Integer> result = new SinglyLinkedList<>();
       for(Integer key : map.keySet()) {
    	   if(map.get(key) > 1) {
    		   result.insertAtEnd(key);
    	   }
       }
       
        return (SinglyLinkedList<T>) result;
    }
    
    public static void main(String[] args) {
    	SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
    	list1.insertAtEnd(15);
    	list1.insertAtEnd(22);
    	list1.insertAtEnd(8);
    	SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
    	list2.insertAtEnd(7);
    	list2.insertAtEnd(14);
    	list2.insertAtEnd(22);
    	
    	SinglyLinkedList<Integer> res1 = union(list1,list2);
    	res1.printList();
    	
    	SinglyLinkedList<Integer> res2 = intersection(list1,list2);
    	res2.printList();
    	
    	
    }
}
