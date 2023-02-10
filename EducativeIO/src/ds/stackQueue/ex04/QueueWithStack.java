package ds.stackQueue.ex04;

public class QueueWithStack {
	private Stack stack;
	
	public QueueWithStack(Stack s) {
		this.stack = s;
	}
	
	//check pass by value and pass by reference in java
	public static void dequeue(Stack stack) {
		@SuppressWarnings("rawtypes")
		Stack cloneStack = new QueueWithStack(stack);
		System.out.println(cloneStack.pop()+" popped!!");
	}
    
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push(12);
		stack.push(13);
		stack.push(18);
		stack.push(20);
		
		dequeue(stack);
		
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
	}

}
