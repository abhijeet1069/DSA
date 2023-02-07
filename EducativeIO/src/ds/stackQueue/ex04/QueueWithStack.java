package ds.stackQueue.ex04;

public class QueueWithStack {
	private Stack stack;
	
	public QueueWithStack(int maxSize){
        this.stack = new Stack(maxSize);
    }
  
    public void enqueue(V value){
      	if()
    	
    	while(!this.stack.isFull()) {
      		this.stack.push(value);
      	}
    }
    public V dequeue(){
		// Write -- Your -- Code
        return null;
    }
    public boolean isEmpty(){
        return this.stack.top() == null;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
