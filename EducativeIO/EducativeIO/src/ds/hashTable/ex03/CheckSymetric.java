package ds.hashTable.ex03;

import java.util.HashMap;

/*
Implement the findSymetric() function to find first occurrence of symmetric pairs in the given array.

Input:
	arr[][] = [{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}]
	
Output:
	"{3,4}{5,9}"
 * */

class CheckSymmetric {
    public static String findSymmetric(int[][] arr) {
        String result = "";
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int first = arr[i][0];
            int second = arr[i][1];
            int val = map.getOrDefault(second,Integer.MIN_VALUE);
            if(val != Integer.MIN_VALUE && val == first){
                result += String.format("{%d,%d}",second,first)+",";
            }
            else{
                map.put(first,second);
            }
        }
        if(result.length() > 0){
            return result.substring(0,result.length()-1);
        }
        else
            return "";
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};
        System.out.println(findSymmetric(arr));
    }
}
