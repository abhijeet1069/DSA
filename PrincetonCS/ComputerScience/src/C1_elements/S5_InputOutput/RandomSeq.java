package C1_elements.S5_InputOutput;

import C1_elements.S5_InputOutput.lib.StdOut;
import C1_elements.S5_InputOutput.lib.StdRandom;

/*
Redirecting standard output to a file: OS will redirect standard output stream to file
	java RandomSeq > data.txt

Piping - Connecting stdout of one program to stdin of other program	
java C1_elements/S5_InputOutput/RandomSeq | java C1_elements/S5_InputOutput/Average
 * */

public class RandomSeq {

	public static void main(String[] args) {
		double lo = 20;
		double high = 30;
		int n = 1000;
		for(int i = 0; i < n; i++) {
			double x = StdRandom.uniformDouble(lo,high);
			StdOut.printf("%.2f\n", x);
		}
	}
}
