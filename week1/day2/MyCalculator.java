package week1.day2;

public class MyCalculator {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		System.out.println("Sum of three numbers : " +calc.addNumbers(4, 5, 6));
		System.out.println("Multiply of two numbers : " +calc.multiplyNumbers(5, 9));
		calc.subtractNumbers();
	}
}
