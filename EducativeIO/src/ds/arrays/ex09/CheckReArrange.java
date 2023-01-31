package ds.arrays.ex09;

import java.util.Arrays;

/**
 Given an array re-arrange its elements in such a way that the negative elements appear on one side and positive
 elements appear on the other.
 Input : arr = {10, -1, 20, 4, 5, -9, -6}
 Output : arr = {-1, -9, -6, 10, 20, 4, 5}
 * */

public class CheckReArrange {
    public static void reArrange(int[] arr){
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, -1, 20, 4, 5, -9, -6};
        reArrange(arr);
        for(int x : arr){
            System.out.print(x+" ");
        }
    }
}
