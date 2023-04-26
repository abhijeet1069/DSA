package ds.stackQueue.ex07;

/**
 For each element in an array, find the next greater element. Also, the next greater element for 
 the last or max value in the array is -1
 Input:
 	arr = {4,6,3,2,8,1}
 Output:
 	result = {6,8,8,8,-1,-1}
 * */

public class NextGreaterChallenge {
	
	public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>(arr.length);
        for(int i = arr.length-1;i >= 0; i--) {
        	while(!stack.isEmpty() && arr[i] >= stack.top()) { //Here, stack is a record of recent highs
        		stack.pop(); //smaller elements between the array element and high removed
        	}
        	if(stack.isEmpty()) {
        		result[i] = -1;
        	}
        	else {
        		result[i] = stack.top();
        	}
        	stack.push(arr[i]);
        }
        return result;
    }

	public static void main(String[] args) {
		int[] arr = new int[] {4,8,3,2,8,1};
		int[] res = nextGreaterElement(arr);
		for(int x : res) {
			System.out.print(x+" ");
		}

	}

}
