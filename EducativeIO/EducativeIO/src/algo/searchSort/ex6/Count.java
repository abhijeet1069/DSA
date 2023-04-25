package algo.searchSort.ex6;

/*
Implement calcFreq() to find the frequency of the occurrence of a given target value in the array.

Sample Input:
	int arr[] = {-5,-3,0,1,3,3,3,4,5};
	int s = 3;
	
Sample Output:
	3
 * */

import java.util.HashMap;

public class Count {

	public static int calcFreq(int arr[], int key) {
		HashMap<Integer,Integer> map = new HashMap<>();
			for(int x : arr) {
				map.put(x, map.getOrDefault(x, 0)+1);
			}
			return map.get(key);
	}
	
	public static void main(String[] args) {
		int arr[] = {-5,-3,0,1,3,3,3,4,5};
		int s = 3;
		System.out.println(calcFreq(arr,s));
	}
}