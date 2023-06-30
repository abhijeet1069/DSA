package fundamentals.programmingModel;

import edu.princeton.cs.algs4.StdOut;

/*
 Static methods allows us to encapsulate and reuse code and to develop programs as a set of independent modules.
 
 Aliasing: (can lead to subtle bugs):
 	int[] a = new int[5];
 	a[1] = 21;
 	int[] b = a;
 	b[2] = 23 //it seems 'b' is modified, but its 'a'
 	
 	for(int i = 0; i < a.length; i++){
 		StdOut.print(a[i]+" "); //Output : 0 21 23 0 0
 	}
 	
 * */

public class Hello {
	public static void main(String[] args) {
		StdOut.println("Hello,World");
	}
}
