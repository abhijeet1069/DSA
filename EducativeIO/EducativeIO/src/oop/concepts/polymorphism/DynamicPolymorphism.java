package oop.concepts.polymorphism;

class Animal {
	public void printAnimal() {
		System.out.print("I am from the Animal class\n");
	}
	void printAnimalTwo() {
		System.out.print("I am from the Animal class\n");
	}
}

class Lion extends Animal {
	// method overriding - Runtime polymorphism
	public void printAnimal() {
		System.out.print("I am from the Lion class\n");
	}
}

public class DynamicPolymorphism {
	public static void main(String[] args) {
		Animal animal;
		Lion lion = new Lion();
		animal = lion;

		animal.printAnimal();
		animal.printAnimalTwo();
	}
}

