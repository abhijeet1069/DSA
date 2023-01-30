package ds.arrays.ex3;
/**
 Return an array of 2 integers that add up to the given number or the original array in case a pair is not found.
 Input:
    arr = {1, 21, 3, 14, 5, 60, 7, 6}
    value = 27
 Output:
    arr = {21, 6} or {6, 21}

 Sorting for binary search : n*lg(n)
 Binary Searching for all key-arrayElements : n*lg(n)
 O(n*lg(n))
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class CheckSum {
    public static int binSearch(int[] arr, int key){
        int low = 0, high = arr.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == key)
                return mid;
            else if(key > arr[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
    public static int[] findSum(int[] arr, int n) {
        int[] result = new int[2];
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            result[0] = arr[i];
            if(binSearch(arr,n-result[0]) != -1) {
                result[1] = n-result[0];
                return result;
            }
        }
        return arr;   // return the elements in the array whose sum is equal to the value passed as parameter
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,21,3,14,5,60,7,6};
        int value = 22;
        for(int temp : findSum(arr,value))
            System.out.println(temp+" ");
    }
}
