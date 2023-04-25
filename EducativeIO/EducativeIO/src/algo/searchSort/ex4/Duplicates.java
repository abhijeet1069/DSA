package algo.searchSort.ex4;

/*
Implement findDuplicates() to find all duplicates that exist in that array. 
Input:
	int arr[] = {1, 3, 4, 3, 5, 4, 100, 100};

Output:
	{3, 4, 100};
 * */

import java.util.ArrayList;
import java.util.HashMap;

public class Duplicates {

	public static ArrayList < Integer > findDuplicates(int[] arr) {
		ArrayList <Integer> duplicates = new ArrayList <Integer>();
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int x : arr) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		for(int x : map.keySet()) {
			if(map.get(x) > 1) {
				duplicates.add(x);
			}
		}
		return duplicates;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,3,4,3,5,4,100,100};
		System.out.println(findDuplicates(arr));
	}
}
