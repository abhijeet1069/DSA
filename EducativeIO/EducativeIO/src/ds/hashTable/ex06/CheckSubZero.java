package ds.hashTable.ex06;

import java.util.HashMap;

/*
 Implement findSubZero() function to check whether a given array has a contiguous sub-array with
 zero sum.
 
 Input:
 	arr = {6, 4, -7, 3, 12, 9}
 	
 Output:
 	true //{4,3,-7}
 	
 Algorithm:
 	Find sum till index and store in HashMap. Here, hash-map is being stored as history.
 * */

class CheckSubZero {

public static boolean findSubZero(int[] arr) {
		HashMap<Integer,Integer> sumMap = new HashMap<>();
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(arr[i] == 0 || sum == 0) {
				return true;
			}
			if(sumMap.containsKey(sum)) { //sumTillNow + zeroEffective = sumTillNow
				return true;
			}
			else {
				sumMap.put(sum,i);
			}
		}
	    return false;
	  }

public static void main(String[] args) {
	int[] arr = new int[] {6, 4, -7, 3, 12, 9};
	System.out.println(findSubZero(arr));
	}
}
