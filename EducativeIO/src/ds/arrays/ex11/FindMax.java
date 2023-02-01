package ds.arrays.ex11;

/**
 Given an integer array, return the max subarray sum.
 Input : arr = {1, 7, -2, -5, 10, -1}
 Output: 11

 Using Kadane's Algorithm where we reset the sum when negative is encountered.
 As negative sum will always reduce the final sum so has to be removed.
 However, this approach doesn't work with an array of negatives.
 * */

public class FindMax {
    public static int findMaxSumSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0; i < arr.length; i++){
            currentSum += arr[i];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,7,-2,-5,10,-1};
        System.out.println(findMaxSumSubArray(arr));
    }
}
