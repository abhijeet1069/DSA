package C1_elements.S3_loops;

//Using Newton's method to approximate sqrt(n)

public class Sqrt {
	public static void main(String[] args) {
		double num = 200;
		double x = num; //approximation is the number itself
		
		for(int i = 0; i < 10 ;i++) {
			x = x - ((x*x-num)/(2.0*x));
		}
		System.out.println(x);
	}
}
