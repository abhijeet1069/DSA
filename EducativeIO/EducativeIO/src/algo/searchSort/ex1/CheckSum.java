package algo.searchSort.ex1;

import java.util.HashSet;

public class CheckSum {

	public static int[] findSum(int[] arr, int n) {
		  int[] result = new int[2];
		  HashSet<Integer> set = new HashSet<>();
		  for(int x : arr) {
			  set.add(x);
		  }
		  for(int x : arr) {
			  if(set.contains(n-x)) {
				  result[0] = x;
				  result[1] = n-x;
				  break;
			  }
		  }
		  return result; // return the elements in the array whose sum is equal to the value passed as parameter 
		 }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,21,3,14,5,60,7,6};
		int value = 81;

	}

}
