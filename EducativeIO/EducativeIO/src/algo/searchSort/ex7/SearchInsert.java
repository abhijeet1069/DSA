package algo.searchSort.ex7;

/*
Implement insertPosition() that inputs a sorted array and a target value and outputs index at which
array should be inserted or the index at which it is already present.

Input:
	int arr[] = {1,3,5,6};
	int target = 5;

Output:
	2
 * */

public class SearchInsert {

	public static int insertPosition(int[] arr, int target) {   
		int arrSize = arr.length;
		//checking of size of array is less than 1
		if(arrSize < 1)
			return -1;  
		int start = 0;
		int end = arrSize - 1;
		int mid = 0, pos = 0;
		//traversing the array
		while(start <= end){
			//calculating the mid value
			mid = start + (end-start)/2;  
			//if mid value equals target return the mid index   
			if(arr[mid] == target)
				return mid;
			//if mid value greater than target search in the left half 
			else if(arr[mid] > target){
				end = mid - 1;
				pos = mid;
			} 
			//otherwise search in the right half
			else {
				start = mid + 1;
				pos = mid + 1;
			}
		}
		return pos;
	}

	public static void main(String[] args) {
		int arr[] = {1,3,5,6};
		int target = 5;
		System.out.println(insertPosition(arr,target));
	}

}
