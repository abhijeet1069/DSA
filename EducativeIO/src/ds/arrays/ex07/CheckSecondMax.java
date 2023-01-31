package ds.arrays.ex07;

import java.util.Arrays;
/**
 Given an integer array return the second-largest element present in the array.
 Input : arr = {9,2,3,6}
 Output : 6
 * */
public class CheckSecondMax {
    public static int findSecondMaximum(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length-2];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,2,3,6};
        System.out.println(findSecondMaximum(arr));
    }
}
