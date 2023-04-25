package c1elements.s5inputOutput.exercises;

import c1elements.s5inputOutput.lib.StdIn;
import java.util.ArrayList;

public class WordCount {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("Enter text: ");
		while(!StdIn.isEmpty()) {
			list.add(StdIn.readString()); //stdin is itself separating the strings based on whitespace. So heavy-lifting is done.
		}	
		System.out.println("Word Count: "+list.size());
	}
}
