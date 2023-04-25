package c1elements.s2datatypes;

public class FibonacciWord {
	public static void main(String[] args) {
		String t0 = "a";
		String t1 = "b";
		String res = "";
		System.out.println(t0+"\n"+t1);
		for(int i = 0; i < 10; i++) {
			res = t0+t1;
			System.out.println(res);
			t0 = t1; //Prep of next iteration
			t1 = res; 
		}
		System.out.println("Let's consume memory");
	}
}
