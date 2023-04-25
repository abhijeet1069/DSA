package algo.searchSort.ex8;

/*
Implement a function that returns the index of the target string in a sorted and sparse 
array of strings.

Input:
	array = {"", "educative", "", "", "",  "hello", "", "learning", "world", "", "", ""};
	target = "educative";
	
Output:
	1
 * */

import java.util.HashMap;

class SparseSearch{
	public static int searchForString(String[] array, String target) {
		HashMap<String,Integer> map = new HashMap<>();
		for(String str : array) {
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		return map.getOrDefault(target,-1);
	}
	
	public static void main(String[] args) {
		String[] array = new String[]{"", "educative", "", "", "",  "hello", "", "learning", "world", "", "", ""};
		String target = "educative";
		System.out.println(searchForString(array,target));
	}
}
