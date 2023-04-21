package ds.arrays.ex04;
/**
 Given an array, return an array where each index stores the product of all numbers except the number on the index itself.
    Input : {1,2,3,4}
    Output : {24,12,8,6}
 Approach:
Index    left                  Actual
    0      1                     1
    1    arr[1-1]*left[1-1]     arr[0] * 1
    2    arr[2-1]*left[2-1]     arr[1]*arr[0]
    3    arr[3-1]*left[3-1]     arr[2]*arr[1]*arr[0]
 Similarly, calculate right and multiply for result.
 * */
public class ProductArray {
    public static int[] findProduct1(int arr[]){ //MyVersion
        int[] result = new int[arr.length];
        int product = 1;
        for(int temp : arr)
            product *= temp;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] != 0){
                result[i] = product/arr[i];
            }
            else{ //resolved to brute force to avoid divide by zero situation
                int lhp = 1;
                int rhp = 1;
                for(int j = 0; j < i; j++)
                    lhp *= arr[j];
                for(int j = i+1; j < arr.length; j++)
                    rhp *= arr[j];
                result[i] = lhp*rhp;
            }
        }
        return result;
    }

    public static int[] findProduct2(int arr[]) { //Better Version
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int[] res = new int[arr.length];

        left[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            left[i] = arr[i-1]*left[i-1];
        }
        right[arr.length-1] = 1;
        for(int i = arr.length-2; i >= 0; i--){
            right[i] = arr[i+1]*right[i+1];
        }
        for(int i = 0; i < res.length; i++){
            res[i] = left[i]*right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,1,5,0};
        for(int temp : findProduct2(arr))
            System.out.print(temp+" ");
    }
}
