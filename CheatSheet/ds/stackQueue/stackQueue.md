1) Implement the String[] findBin(int number) method to generate binary numbers from 1 to any given number (n).
Input:
	n = 3
Output:
	result = {"1","10","11"}

Location : EducativeIO.ds.stackQueue.ex01.FindBinChallenge

public static String[] findBin(int number) {
        String[] result = new String[number];
        Queue<String> queue = new Queue<>(number+1);
        queue.enqueue("1");
        for(int i = 0; i < number; i++) {
        	String temp = queue.dequeue();
        	result[i] = temp;
        	queue.enqueue(temp+"0"); //recursive way to generate binary strings
        	queue.enqueue(temp+"1");
        }
        return result; 
    }

2) Implement queue using a stack.
 Input/Output 
	enqueue()
		Input: an integer
		Output: returns true after inserting value in the queue
	dequeue()
		Input: an integer
		Output: returns true after removing value from the queue

Location : EducativeIO.ds.stackQueue.ex04.QueueWithStack

This example is very good demonstration of abstraction. I am using all the operations of queue externally. But internally its being all done by a stack.

public class QueueWithStack <V> {
	private Stack originStack;
	private Stack tempStack;
    public QueueWithStack(int maxSize){
        originStack = new Stack(maxSize);
        tempStack = new Stack(maxSize);
    }
  
    public void enqueue(V value){
      	originStack.push(value);
    }
    public V dequeue(){
		while(!originStack.isEmpty()) { //reverse stack
			tempStack.push(originStack.pop());
		}
		
		V result = (V) tempStack.pop(); //pop the item
		
		while(!tempStack.isEmpty()) {
			originStack.push(tempStack.pop()); //reset to original status
		}
		
        return result;
    }
    public boolean isEmpty(){
        return originStack.isEmpty();
    }

3)  For each element in an array, find the next greater element. Also, the next greater element for the 
    last or max value in the array is -1
    Input:
 	    arr = {4,6,3,2,8,1}
    Output:
 	    result = {6,8,8,8,-1,-1}

    Location : EducativeIO.ds.stackQueue.ex07.NextGreaterChallenge

    This is also a good problem with stack. Must be learnt as an extra tool, as the solution is quite counter-intutive. 

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