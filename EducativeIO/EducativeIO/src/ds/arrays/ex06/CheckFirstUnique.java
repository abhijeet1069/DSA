package ds.arrays.ex06;

import java.util.HashMap;
import java.util.Map;
/**
Given an array, find the first integer, which is unique in the array.
 Input: arr = {9, 2, 3, 2, 6, 6}
 Output: 9

 We are using below data structure:
 Key    Count(value[0])   First-Index(value[1])
 9        1                     0
 2        2                     1
 3        1                     2
 6        2                     4

**/
public class CheckFirstUnique {
    public static int findFirstUnique(int[] arr){
        int result = 0;
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i = 0 ; i < arr.length; i++){
            int[] count = map.getOrDefault(arr[i],new int[]{0,i});
            count[0] = count[0]+1;
            map.put(arr[i],count);
        }
        Map.Entry<Integer, int[]> firstMap = map.entrySet().iterator().next(); //first key value pair
        int minIndex = firstMap.getValue()[1];
        int minKey = firstMap.getKey();
        for(int key : map.keySet()){
            int count = map.get(key)[0];
            int index = map.get(key)[1];
            if(count == 1){
                if(minIndex > index){
                    minIndex = index;
                    minKey = key;
                }
            }
        }
        return minKey;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,2,3,2,6,6};
        System.out.println(findFirstUnique(arr));
    }
}
