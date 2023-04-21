package ds.arrays.ex07;

import java.util.Arrays;
/**
 Given an integer array return the second-largest element present in the array.
 Input : arr = {9,2,3,6}
 Output : 6
 * */
public class CheckSecondMax {
    public static int findSecondMaximum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sec_max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]) { //ascending order sequence
                sec_max = max;
                max = arr[i];
            }
            if(sec_max < arr[i] && arr[i] != max){ //descending order sequence
                sec_max = arr[i];
            }
        }
        return sec_max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,1,5,0};
        System.out.println(findSecondMaximum(arr));
    }
}
