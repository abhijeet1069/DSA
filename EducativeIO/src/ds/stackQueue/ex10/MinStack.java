package ds.stackQueue.ex10;

/**
Return min of sack in O(1) time.
 Input:
    stack = top->9,3,1,4,2,5
 Output:
    1

 Logic:
    Max until now logic has been used. For a given stack find the min until now and return tos.
    stack =         9,3,1,4,2,5
    MinUntilNow =   1,1,1,2,2,5

 Doesn't matter how many insertions or deletions are there, minUntilNow will return the min element.
 * */

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
    
    
    
    
    
    public static void main(String[] args) {
    	MinStack stack = new MinStack(6);
    	stack.push(5);
    	stack.push(2);
    	stack.push(4);
    	stack.push(1);
    	stack.push(3);
    	stack.push(-1);
    	
    	stack.pop();
    	
    	System.out.println(stack.min());
    }
}
