package c1elements.s5inputOutput.exercises;

import java.util.ArrayList;

import c1elements.s5inputOutput.lib.StdIn;

public class Stats {

	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<>();
		System.out.println("Average and SD calculator: Press Ctrl+D to stop");
		System.out.println("Digits: ");
		while(!StdIn.isEmpty()) {
			list.add(StdIn.readDouble());
		}
		int avg = 0, sd = 0;
		int size = list.size();
		for(int i = 0; i < size; i++) {
			avg += list.get(i); //Adding smaller quantities to prevent overflow
		}
		avg = avg/size;
		for(int i = 0; i < size; i++) {
			sd += Math.pow(list.get(i)-avg, 2);
		}
		sd = sd/(size-1);
		System.out.println("Average: "+avg+" , S.D: "+sd);
	}

}
