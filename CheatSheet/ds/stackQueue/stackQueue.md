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

4.  Celebrity Problem : Find the celebrity where celebrity is someone that everyone knows, but he doesn't know anyone.
 If party[row][col] == 1, then row knows col.
Input:
    party = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,0},
                {0,1,1,0},
            }
 numPeople = 4 (Number of rows in party array)

 Output:
    2 (because row Index = 2 is a celebrity)

  Location : EducativeIO.ds.stackQueue.ex08.FindCelebChallenge

 Using a stack to minimise comparisons is ingenious. Optimization is based on everyone. Pop 2 Push 1 logic.

public static int findCelebrity(int[][] party, int numPeople) {
        int celebrity = -1;
        Stack<Integer> stack = new Stack<>(numPeople);
        for(int i = 0; i < numPeople; i++){
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int a = stack.pop();
            if(stack.isEmpty()){
                celebrity = a;
                break;
            }
            int b = stack.pop();
            if(party[a][b] == 1){
                stack.push(b); //discard a since he knows b, so he is definitely not a celebrity
            }
            else{
                stack.push(a); //discard b as a doesn't know b, so he is definitely not a celebrity.
            }
        }

        //final check whether last person is celebrity
        for(int i = 0; i < numPeople && i != celebrity; i++){
            if(party[celebrity][i] == 1 || party[i][celebrity] == 0 ){ //if celebrity knows i or if i does not know celebrity
                return -1;
            }
        }
        return celebrity;
    }

5. Return min of sack in O(1) time.
 Input:
    stack = top->9,3,1,4,2,5
 Output:
    1

 Logic:
    Max until now logic has been used. For a given stack find the min until now and return tos.
    stack =         9,3,1,4,2,5
    MinUntilNow =   1,1,1,2,2,5

 Doesn't matter how many insertions or deletions are there, minUntilNow will return the min element.

 Location : EducativeIO.ds.stackQueue.ex10.MinStack

 public class MinStack {
	
	int maxSize;
    Stack<Integer> originalStack;
    Stack<Integer> minStack;
    int min; //single element for O(1) operation
    
    //constructor
    public MinStack(int maxSize) {
    	this.min = Integer.MAX_VALUE;
        this.maxSize = maxSize;
        this.originalStack = new Stack<>(maxSize);
        this.minStack = new Stack<>(maxSize);
    }
    //removes and returns value from stack
    public Integer pop(){
        int val = this.originalStack.pop();
        this.minStack.pop();
        return val;
    }
    //pushes value into the stack
    public void push(Integer value){
        this.originalStack.push(value);
        this.min = Math.min(this.min, value);
        this.minStack.push(min);
    }
    //returns minimum value in O(1)
    public int min(){
		if(this.minStack.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		else {
			return this.minStack.top();
		}
        
    }