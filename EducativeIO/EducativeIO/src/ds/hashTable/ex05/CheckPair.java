package ds.hashTable.ex05;

import java.util.HashMap;

/*
Implement the findPair() function to find two pairs of elements such that (a+b) = (c+d)
Input:
	arr = {3, 4, 7, 1, 12, 9}
	
Output:
	"{4,12}{7,9}"
	
Algorithm:
	Using sum as key
 **/

class Pair {
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		String str = String.format("{%d,%d}",x, y);
		return str;
	}
}

public class CheckPair {

public static String findPair(int[] arr) {
	    String result = "";  
	    HashMap<Integer,Pair> map = new HashMap<>();
	    for(int i = 0; i < arr.length-1; i++) {
	    	for(int j = i+1; j < arr.length; j++) {
	    		int sum = arr[i]+arr[j];
	    		if(map.containsKey(sum)) {
	    			Pair temp = new Pair(arr[i],arr[j]);
	    			result = map.get(sum).toString()+temp.toString();
	    			break;
	    		}
	    		else {
	    			map.put(sum, new Pair(arr[i],arr[j]));
	    		}
	    	}
	    }
	    return result; 
	  }

public static void main(String[] args) {
	int[] arr = new int[] {3, 4, 7, 1, 12, 9};
	System.out.println(findPair(arr));
	}
}










