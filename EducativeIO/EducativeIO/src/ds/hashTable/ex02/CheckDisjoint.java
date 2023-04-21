package ds.hashTable.ex02;

import java.util.HashMap;

/*
Implement the isDisjoint() function to check whether two given arrays are disjoint or not.
Disjoint arrays mean that their intersection returns nothing.

Input:
	arr1 = [9,4,3,1,-2,6,5]
	arr2 = [7,10,8]
	
Output:
	true
 **/

public class CheckDisjoint {
    public static Object isDisjoint(int[] arr1,int[] arr2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr1.length; i++){
            map.put(arr1[i],i);
        }
        for(int i = 0; i < arr2.length; i++){
            if(map.get(arr2[i]) != null){ //if anyone element not found
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isDisjoint(new int[]{9,4,3,1,-2,6,5},new int[]{7,10,8}));
    }
}
