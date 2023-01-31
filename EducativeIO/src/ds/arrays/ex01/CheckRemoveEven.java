package ds.arrays.ex01;

import java.util.ArrayList;

/**
    Remove Even Integers from an Array:
    Input : arr = {1, 2, 4, 5, 10, 6, 3}
    Output: arr = {1, 5, 3}
**/

public class CheckRemoveEven {
    public static int[] removeEven(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        int[] temp = new int[arr.length];
        int oddCount = 0;
        for(int x : arr){
            if(x%2 != 0){
                temp[oddCount] = x;
                oddCount++;
            }
        }
        int[] res = new int[oddCount];
        for(int  i = 0 ; i < res.length; i++)
            res[i] = temp[i];

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,4,5,10,6,3};
        for(int x : removeEven(arr))
            System.out.print(x+" ");
    }
}
