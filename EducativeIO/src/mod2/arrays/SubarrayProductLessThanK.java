package mod2.arrays;

/*
All positive integers.
* */

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){

        }

        return subarrays;
    }

    public static void main(String[] args){
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}
