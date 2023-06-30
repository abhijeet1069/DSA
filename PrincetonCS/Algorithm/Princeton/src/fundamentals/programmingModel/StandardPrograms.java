package fundamentals.programmingModel;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;

public class StandardPrograms {

	public static <T extends Comparable<T>> T max(T[] arr) {
		T max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i].compareTo(max) > 0) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static <T extends Number> double average(T[] arr) {
		int n = arr.length;
		double sum = 0.0;
		for(int i = 0; i < n; i++) {
			sum += arr[i].doubleValue();
		}
		return sum/n;
	}
	
	public static <T> T[] copy(T[] arr) {
		T[] copy = Arrays.copyOf(arr,arr.length);
		return copy;
	}
	
	public static <T extends Number> void reverse(T[] arr) {
		int N = arr.length;
		for(int  i = 0; i < N/2; i++) {
			T temp = arr[i];
			arr[i] = arr[N-i-1];
			arr[N-i-1] = temp;
		}
	}
	
	public static <T> void print(T[] arr) {
		int N = arr.length;
		for(int i = 0; i < N; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {1,2,3,4,5};
		print(arr);
		reverse(arr);
		print(arr);
		StdDraw.square(0.2, 0.8, 0.1);

	}
}
