package ds.stackQueue.ex04;

/**
 Implement queue using a stack.
 Input/Output 
	enqueue()
		Input: an integer
		Output: returns true after inserting value in the queue
	dequeue()
		Input: an integer
		Output: returns true after removing value from the queue
 */

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
    
	public static void main(String[] args) {
	
		//Abstraction.Internally QueueWithStack is using a stack but we don't know.
		QueueWithStack<Integer> queue = new QueueWithStack<>(5); 
		queue.enqueue(12);
		queue.enqueue(24);
		queue.enqueue(28);
		queue.enqueue(33);
		queue.enqueue(45);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
	}

}
