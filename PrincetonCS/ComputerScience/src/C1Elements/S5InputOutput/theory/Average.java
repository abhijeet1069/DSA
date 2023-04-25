package c1elements.s5inputOutput.theory;

import c1elements.s5inputOutput.lib.StdIn;
import c1elements.s5inputOutput.lib.StdOut;

/*
Redirecting standard input from a file
	java C1_elements/S5_InputOutput/Average < data.txt
 * */

public class Average{
	public static void main(String[] args) {
		int count = 0;
		double sum = 0.0;
		
		while(!StdIn.isEmpty()) {
			double value = StdIn.readDouble();
			sum += value;
			count++;
		}
		double average = sum/count;
		StdOut.println("Average is: "+average);
	}
}