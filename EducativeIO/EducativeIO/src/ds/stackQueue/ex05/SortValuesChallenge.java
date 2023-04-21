package ds.stackQueue.ex05;

/**
 Given a stack, sort the values in ascending order.
 Input:
 	stack = {23,60,12,42,4,97,2}
 Output:
 	result = {2,4,12,23,42,60,97}
 * */

import java.util.Arrays;

public class SortValuesChallenge {

	public static void sortStack(Stack<Integer> stack) {
       int[] arr = new int[stack.getCurrentSize()];
       for(int i = 0; i < arr.length; i++) {
    	   arr[i] = stack.pop();
       }
       
       Arrays.sort(arr);
       
       for(int i = arr.length-1; i>= 0; i--) {
    	   stack.push(arr[i]);
       }
       
    }
	
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		
		stack.push(2);
		stack.push(102);
		stack.push(20);
		stack.push(12);
		stack.push(40);
		
		sortStack(stack);
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
}
