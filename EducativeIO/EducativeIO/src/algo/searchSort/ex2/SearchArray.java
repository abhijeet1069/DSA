package algo.searchSort.ex2;

/*
Implement searchRotatedArray() that inputs a sorted array that has been rotated a number of times
and return the index of the element.

Input:
	A sorted array that has been rotated a number of times.
	int arr[] = {7, 8, 9, 0, 3, 5, 6}    // Given Array
	int left = 0;     // Starting Index of the Array
	int right = 6;    // Ending Index of the Array
	int n = 3;        // Key to Search
	
Output:
	The index of the element.
		4             // Index where the Key is found!
 * */

public class SearchArray {

	static int searchRotatedArray(int arr[], int left, int right, int n) {
		int result = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == n) {
				result = i;
			}
		}
				  return result;
	}
	
	public static void main(String[] args) {
		int arr[] = new int[]{7, 8, 9, 0, 3, 5, 6};    // Given Array
		int left = 0;     // Starting Index of the Array
		int right = 6;    // Ending Index of the Array
		int n = 3;        // Key to Search
		System.out.println(searchRotatedArray(arr,left,right,n));
	}

}
