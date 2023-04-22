package ds.hashTable.ex08;

import java.util.HashMap;

/*
Implement union and intersection of lists.
 
Input:
 	list1 = 15->22->8->null
	list2 = 7->14->22->null
	
Output:
	Union = 15->22->8->7->14->null
	Intersection = 22->null
 * */

public class CheckUnionIntersection {
    public static <V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list) {
        SinglyLinkedList<Integer> result = new SinglyLinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(SinglyLinkedList.Node temp = list.getHeadNode(); temp != null; temp = temp.nextNode) {
        	if(!map.containsKey(temp.data)) {
        		result.insertAtEnd((Integer) temp.data);
        		map.put((Integer) temp.data, 1);
        	}
        }
        list.setHeadNode((SinglyLinkedList<V>.Node) result.getHeadNode());
    }
	
    //Traverse both lists and weed out the duplicates
    public static <T> SinglyLinkedList<T> unionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        for(SinglyLinkedList.Node temp = list1.getHeadNode(); temp != null; temp = temp.nextNode) {
        	result.insertAtEnd((T) temp.data);
        }
        for(SinglyLinkedList.Node temp = list2.getHeadNode(); temp != null; temp = temp.nextNode) {
        	result.insertAtEnd((T) temp.data);
        }
        removeDuplicatesWithHashing(result);
        return result;
    }
    
    //Remove duplicates of individual lists. Find whose count >1. That is the intersection
    public static <T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        removeDuplicatesWithHashing(list1);
        removeDuplicatesWithHashing(list2);
        HashMap<Integer,Integer> map = new HashMap<>(); //value,count
        for(SinglyLinkedList.Node temp = list1.getHeadNode(); temp != null; temp = temp.nextNode) {
        	map.put((Integer) temp.data, map.getOrDefault(temp.data, 0)+1);
        }
        for(SinglyLinkedList.Node temp = list2.getHeadNode(); temp != null; temp = temp.nextNode) {
        	map.put((Integer) temp.data, map.getOrDefault(temp.data, 0)+1);
        }
        
        for(Integer i : map.keySet()) {
        	if(map.get(i) > 1) {
        		result.insertAtEnd((T) i);
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
    	SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
    	SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
    	
    	list1.insertAtEnd(15);
    	list1.insertAtEnd(22);
    	list1.insertAtEnd(8);
    	
    	list2.insertAtEnd(7);
    	list2.insertAtEnd(14);
    	list2.insertAtEnd(22);
    	
    	unionWithHashing(list1,list2).printList();
    	intersectionWithHashing(list1,list2).printList();
    	
    	
    	
    }
}
