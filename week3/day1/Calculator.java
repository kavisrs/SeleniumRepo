package week3.day1;

public class Calculator {
	//static polymorphism - ability of a class to provide different implementation of methods
	
	public void add(int a, int b) {
		System.out.println(a+b);

	}
	public void add(int a, int b, int c) {
		System.out.println(a+b+c);

	}
	public void multiple(double a, double b) {
		System.out.println(a*b);
	}
	
	public void multiple(int a, double b) {
		System.out.println(a*b);
	}

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.add(10,20);
		c.add(1, 2, 3);
		c.multiple(10.1234, 11.9887);
		c.multiple(1, 3.8767);
		
	}
}
