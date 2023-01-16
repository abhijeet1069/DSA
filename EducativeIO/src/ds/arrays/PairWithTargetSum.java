package ds.arrays;

public class PairWithTargetSum {

	  public static int[] search(int[] arr, int targetSum) {
	    int left = 0, right = arr.length-1;
	    while(left < right) {
	    	int sum = arr[left]+arr[right];
	    	if(sum == targetSum)
	    		return new int[] {left,right};
	    	else if(sum > targetSum) //decrease sum
	    		right--;
	    	else
	    		left++;
	    }
	    return new int[] { -1, -1 };
	  }
	  
	  public static void main(String[] args) {
		  int[] arr = new int[] {2, 5, 9, 11};
		  int targetSum = 11;
		  int[] res = search(arr,targetSum);
		  for(int i : res)
			  System.out.println(i);
	  }
	}
