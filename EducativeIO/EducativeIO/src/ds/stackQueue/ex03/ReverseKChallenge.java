package ds.stackQueue.ex03;
/*
Implement the void reverseK(Queue<V> queue, int k) method; this will take a queue and any number (k) as input, 
and reverse the first k elements of the queue.

Input:
	Queue = {1,2,3,4,5,6,7,8,9,10}
	k = 5
	
Output:
	result = {5,4,3,2,1,6,7,8,9,10}
 * */
public class ReverseKChallenge {
	public static <V> void reverseK(Queue<V> queue, int k) {
        Stack<V> stack = new Stack<>(k);
        Queue<V> tempQueue = new Queue<>(queue.getMaxSize()-k);
        for(int i = 1; i <= k ; i++) {
        	stack.push(queue.dequeue());
        }
        
        while(!queue.isEmpty()) {
        	tempQueue.enqueue(queue.dequeue());
        }
        //start filling queue in proper positions
        while(!stack.isEmpty()) {
        	queue.enqueue(stack.pop());
        }
        
        while(!tempQueue.isEmpty()) {
        	queue.enqueue(tempQueue.dequeue());
        }
    }
	
	public static void main(String[] args) {
		int size = 10;
		Queue<Integer> queue = new Queue<>(size);
		for(int i = 1; i <= 10; i++) {
			queue.enqueue(i);
		}
		
		reverseK(queue,5);
		while(!queue.isEmpty()) {
			System.out.print(queue.dequeue()+" ");
		}
	}
}
