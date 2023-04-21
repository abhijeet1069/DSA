package ds.stackQueue.ex01;

/*
Implement the String[] findBin(int number) method to generate binary numbers from 1 to any given number (n).
Input:
	n = 3
Output:
	result = {"1","10","11"}
 * */

public class FindBinChallenge {
    public static String[] findBin(int number) {
        String[] result = new String[number];
        Queue<String> queue = new Queue<>(number+1);
        queue.enqueue("1");
        for(int i = 0; i < number; i++) {
        	String temp = queue.dequeue();
        	result[i] = temp;
        	queue.enqueue(temp+"0");
        	queue.enqueue(temp+"1");
        }
        return result; 
    }
    
    public static void main(String[] args) {
    	String[] arr = findBin(5);
    	for(String temp : arr) {
    		System.out.print(temp+" ");
    	}
    }
}
