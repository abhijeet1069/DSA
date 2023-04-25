package c1elements.s5inputOutput.exercises;

import c1elements.s5inputOutput.lib.StdIn;

public class MaxMin {
	public static void main(String[] args) {
		int input = 0;
		try {
			System.out.println("Enter an integer input. Press Ctrl+d to exit in Mac ,Ctrl+z to exit in Windows");
			int max = StdIn.readInt();
			int min = max;
			while(!StdIn.isEmpty()) {
				input = StdIn.readInt();
				if(input < min) {
					min = input;
				}
				if(input > max) {
					max = input;
				}
			}
			System.out.println("\nMin = "+min+", Max = "+max);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
