package ds.stackQueue.ex10;

/*
 min stack logic is quite ingenious, this can be utilised for other applications too.
 * */

public class MinStack {
	
	int maxSize;
    Stack<Integer> originalStack;
    Stack<Integer> minStack;
    int min;
    
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
