package algo.searchSort.ex9;

/*
The output is a printed array where 0's , 1's and 2's are sorted.

Input:
	arr = {2, 0, 0, 1, 2, 1, 0};
	
Output:
	0 0 0 1 1 2 2
 * */

import java.util.Arrays;

public class DutchFlag {

	public static void dutchNationalFlag(int [] arr){ 
	     Arrays.sort(arr);
		    for(int x : arr)
		    	System.out.print(x+" " );
	  }
	
	public static void main(String[] args) {
		int[] arr = new int[] {2,0,0,1,2,1,0};
		dutchNationalFlag(arr);
	}
}
