package dsa.divideAndConquer;

public class MergeSort {
	
	public static void merge(int[] array, int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = array[middle + 1 + j];

        // Merge the temporary arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
	
	public static void mergeSort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			System.out.println("left = "+left+" ,right = "+right+" ,mid = "+mid);
			mergeSort(arr,left,mid);
			mergeSort(arr,mid+1,right);
			merge(arr,left,mid,right);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {12, 11, 13, 5, 6, 7};
		mergeSort(arr, 0, arr.length-1);
		
		System.out.println("Sorted Array\n");
		for(int i : arr)
			System.out.print(i+" ");
		System.out.println();
	}
}
