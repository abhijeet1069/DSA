package ds.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TripletSumToZero {
	  
	public static List<Integer> sumOfPair(List<Integer> list, int sum){
		Collections.sort(list);
		int left = 0, right = list.size()-1;
		while(left < right) {
			int currSum = list.get(left)+list.get(right);
			if(sum == currSum){
				List<Integer> temp = new ArrayList<>();
				temp.add(list.get(left));
				temp.add(list.get(right));
				return temp;
			}
			else if(sum > currSum)
				left++;
			else
				right--;
					
		}
		return null;
	}
		
	public static List<List<Integer>> searchTriplets(int[] arr) {
	    List<List<Integer>> triplets = new ArrayList<>();
	    for(int i = 0; i < arr.length; i++) {
	    	List<Integer> input = new ArrayList<>();
	    	for(int j = 0; j < arr.length && j != i; j++) 
	    		input.add(arr[j]);
	    	
	    	List<Integer> triplet;
	    	if((triplet = sumOfPair(input,-arr[i])) != null) {
	    		triplet.add(arr[i]);
	    		triplets.add(triplet);
	    	}
	    }
	    return triplets;
	  }
	
	public static void main(String[] args) {
		int[] arr = new int[] {-3, 0, 1, 2, -1, 1, -2};
	    //List<Integer> list = new ArrayList<Integer>();
	    System.out.println(searchTriplets(arr));
		}
	}
