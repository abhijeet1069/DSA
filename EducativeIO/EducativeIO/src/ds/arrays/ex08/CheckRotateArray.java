package ds.arrays.ex08;

/**
 Given an array, rotate its elements once from right to left.
 Input: arr = {1, 2, 3, 4, 5}
 Output : arr = {5, 1, 2, 3, 4}
 * */

public class CheckRotateArray {
    public static void rotateArray(int[] array){
        int last = array[array.length-1];
        for(int i = array.length-1; i > 0; i--){
            array[i] = array[i-1];
        }
        array[0] = last;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        rotateArray(array);
        for(int x : array)
            System.out.print(x+" ");
    }
}
