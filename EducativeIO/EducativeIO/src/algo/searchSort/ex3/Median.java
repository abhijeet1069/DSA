package algo.searchSort.ex3;

/*
Input:
	Two sorted arrays.
	A = {100};
	B = {1, 5, 8, 10, 20}

Output:
	The median of two arrays.
	9.0
 * */

public class Median {
	
	public static double getMedian(int array1[], int array2[]) {
		double result = -Double.MAX_VALUE; 
		int n1 = array1.length;
		int n2 = array2.length;
		int n3 = n1 + n2;
		int[] array3 = new int[n1+n2];
		int k = 0 , i = 0, j = 0;
		while(i < n1 && j < n2) {
			if(array1[i] < array2[j]) {
				array3[k] = array1[i];
				i++;
			}
			else {
				array3[k] = array2[j];
				j++;
			}
			k++;
		}
		
		while(i < n1) {
			array3[k] = array1[i];
			i++;
			k++;
		}
		
		while(j < n2) {
			array3[k] = array2[j];
			j++;
			k++;
		}
		
		if(n3 % 2 == 0) {
			result = (array3[n3/2] + array3[n3/2 - 1])/2.0;
		}
		else {
			result = array3[n3/2];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = new int[]{100};
		int[] B = new int[]{1, 5, 8, 10, 20};
		System.out.println(getMedian(A,B));
	}
}
