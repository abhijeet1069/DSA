package ds.arrays;

public class MaxInBitonicArray {

	  public static int findMax(int[] arr) {
	    for(int i = 0; i < arr.length-1; i++) {
	    	if(arr[i] > arr[i+1])
	    		return arr[i];
	    }
	    return arr[arr.length-1];
	  }

	  public static void main(String[] args) {
	    System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
	    System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
	    System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
	    System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
	  }
	}
