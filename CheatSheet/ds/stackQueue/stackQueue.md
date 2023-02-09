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