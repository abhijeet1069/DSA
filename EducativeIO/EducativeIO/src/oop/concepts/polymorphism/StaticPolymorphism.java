package oop.concepts.polymorphism;

class Sum {
	  public int addition(int a, int b) { //Method Overloading
		  return a + b;		//Operator overloading is also a type of static polymorphism. But not supported in JAVA.
	  }

	  public int addition(int a, int b, int c) {
		  return a + b + c;
	  }
	}

	public class StaticPolymorphism {
	  public static void main(String[] args) {
	    Sum sum = new Sum();
		System.out.print(sum.addition(14, 35));
		System.out.print("\n");
		System.out.print(sum.addition(31, 34, 43));
	  }
	}