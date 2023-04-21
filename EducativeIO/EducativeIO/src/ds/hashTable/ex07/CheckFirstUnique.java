package ds.hashTable.ex07;

import java.util.HashMap;

/*
Implement the findFirstUnique() function that will look for first occurrence of unique integer.

Input:
	arr = {9, 2, 3, 2, 6, 6}

Output:
	9

Algorithm:
 	Here we are using hash-map as a DB of count and index of each array element
 
 */

class IndexData{
	int index;
	int count;
	IndexData(int index, int count){
		this.index = index;
		this.count = count;
	}
}

public class CheckFirstUnique
{
  public static int findFirstUnique(int[] arr){
	    int result = 0;
	    HashMap<Integer,IndexData> map = new HashMap<>();
	    for(int i = 0; i < arr.length; i++) {
	    	if(map.containsKey(arr[i])) {
	    		IndexData temp = map.get(arr[i]);
	    		temp.count++;
	    		map.put(arr[i], temp);
	    	}
	    	else {
	    		map.put(arr[i], new IndexData(i,1));
	    	}
	    }
	    
	    for(int i : map.keySet()) {
	    	int minIndex = arr.length;
	    	if(map.get(i).count == 1) {
	    		if(minIndex > map.get(i).index) {
	    			minIndex = map.get(i).index;
	    			result = i;
	    		}
	    	}
	    }
	    return result;
	  }
  
public static void main(String[] args) {
	int[] arr = new int[] {9, 2, 3, 2, 6, 6};
	System.out.println(findFirstUnique(arr));
}
  
  
  
}
