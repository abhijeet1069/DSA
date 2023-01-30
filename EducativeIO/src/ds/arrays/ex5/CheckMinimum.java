package ds.arrays.ex5;

/**
 Given an array, find the minimum value in the array.
 Input : arr = {9,2,3,6}
 Output : 2
 * */
public class CheckMinimum {
    public static int findMinimum(int[] arr) {
        int min = arr[0];
        for(int  i = 1; i < arr.length; i++){
            if(min > arr[i]) //store the smaller element
                min = arr[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,2,3,6};
        System.out.println(findMinimum(arr));
    }
}
