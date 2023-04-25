package algo.searchSort.ex5;

/*
Implement a function that tells whether a given target is present in the sorted matrix or not.
Input:
	matrix  = {{10, 11, 12, 13},
          {14, 15, 16, 17},
          {27, 29, 30, 31},
          {32, 33, 39, 80}};

	target = 30
	
Output:
	true
	
 Using the architecture of 2D matrices.
 * */

public class SearchMatrix {
	public static Object findKey(int[][] matrix, int numberOfRows, int numberOfColumns, int target) {
		int i = numberOfRows - 1;
		int j = 0;

		while (i >= 0 && j < numberOfColumns) {
			if (matrix[i][j] == target)
				return true;
			if (target > matrix[i][j])
				j++;
			else
				i--;
		  }
		  return false;
		 }
	
	 public static void main(String args[]) {
		  
		  int[][] matrix = {
		      {10, 11, 12, 13},
		      {14, 15, 16, 17},
		      {27, 29, 30, 31},
		      {32, 33, 39, 50}
		    };

		   // Example 1
		  Object x = findKey(matrix, 4, 4, 80);
		  System.out.println("Search for 80 returned: " + x);
		  
	 }
}
