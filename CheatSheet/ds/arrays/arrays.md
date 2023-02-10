1) Merging two sorted arrays in a single array:
    
    Location : EducativeIO.ds.arrays.ex02.CheckMergeArray
    
    This merge has an interesting use of while loop instead of using Integer.MAX
    while(i < size1 && j < size2){
        }
    while(i < size1){ //consume remaining elements if left in array
        }
    while(j < size2){ //consume remaining elements if left in array
        }

2) Find product of all elements in array except itself.
    Input : {1,2,3,4}
    Output : {24,12,8,6}

    Location : EducativeIO.ds.arrays.ex04.ProductArray

    public static int[] findProduct2(int arr[]) { //Better Version
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int[] res = new int[arr.length];

        left[0] = 1;
        for(int i = 1; i < arr.length; i++) { //left product component
            left[i] = arr[i-1]*left[i-1];
        }
        right[arr.length-1] = 1;
        for(int i = arr.length-2; i >= 0; i--){ //right product component
            right[i] = arr[i+1]*right[i+1];
        }
        for(int i = 0; i < res.length; i++){
            res[i] = left[i]*right[i];
        }
        return res;
    }

    3) Find the max sub-array sum.
        Input : arr = {1, 7, -2, -5, 10, -1}
        Output: 11

        Location : EducativeIO.ds.arrays.ex11.FindMax

        public static int findMaxSumSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0; i < arr.length; i++){
            currentSum += arr[i];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
            if(currentSum < 0){ //ignoring the negative component. Positive component however small will 
                currentSum = 0; // only add to the value
            }
        }
        return maxSum;
    }