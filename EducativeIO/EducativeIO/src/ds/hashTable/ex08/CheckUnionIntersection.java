package ds.hashTable.ex08;

import java.util.HashMap;

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
    	SinglyLinkedList<Integer> list,list2 = new SinglyLinkedList<>();
    }
}
