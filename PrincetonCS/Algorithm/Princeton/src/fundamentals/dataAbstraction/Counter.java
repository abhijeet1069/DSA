package fundamentals.dataAbstraction;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Counter implements Comparable<Counter>{

	private final String name;
	private int count = 0;
	
	public Counter(String id) {
		name = id;
	}
	
	public void increment() {
		count++;
	}
	
	public int tally() {
		return count;
	}
	
	public String toString() {
		return count+" "+name;
	}
	
	@Override
	public int compareTo(Counter that) {
		return Integer.compare(this.count,that.count);
	}
	
	public static void main(String[] args) {
		int n = 6;
		int trials = 1000;
		
		Counter[] hits = new Counter[n];
		for(int i = 0; i < n ; i++) {
			hits[i] = new Counter("Counter "+i);
		}
		
		for(int t = 0; t < trials; t++) {
			hits[StdRandom.uniformInt(n)].increment();
		}
		
		for(int i = 0; i < n ; i++) {
			StdOut.println(hits[i]);
		}
	}
}
