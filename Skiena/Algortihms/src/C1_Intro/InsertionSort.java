package C1_Intro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {
	
	public static void insertion_sort(int[] arr) {
		int i,j,temp;
		for(i = 1; i < arr.length; i++) {
			j = i;
			while((j > 0) && (arr[j] < arr[j-1])) { //this line prevents unnecessary comparisons.
				temp = arr[j];                      //if elements are in ascending order then no need to check further on left
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				
				j = j-1;
			}
		}
	}

	
	public static void main(String[] args) {
		readCsv();
	}
}
