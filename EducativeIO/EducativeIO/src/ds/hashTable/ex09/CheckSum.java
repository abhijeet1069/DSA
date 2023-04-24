package ds.hashTable.ex09;

import java.util.HashSet;

/*
Implement the findSum(int[] arr, int n) function, that returns an array of two integers that add
up to n in an array.

Input:
	arr = {1, 21, 3, 14, 5, 60, 7, 6}
	value = 27
	
Output:
	arr = {21, 6} or {6, 21}
 * */

public class CheckSum{   
	public static int[] findSum(int[] arr, int n){
		int[] result = new int[2];  
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i: arr){
			if(set.contains(n - i)){
				result[0] = i;
				result[1] = n - i;
				break;
			}
			set.add(i);
		}
		return result;   
	}
	

	public static void main(String[] args) {
		int[] arr = new int[] {1, 21, 3, 14, 5, 60, 7, 6};
		int value = 27;
		
		
		arr = findSum(arr,value);
		String res = "";
		for(int i = 0; i < arr.length; i++) {
			res += arr[i]+" ";
		}
		System.out.println(res);
	}
}