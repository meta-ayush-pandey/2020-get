import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		HexCalc hexa        = new HexCalc();
		Scanner sc          = new Scanner(System.in);

		System.out.println(" enter first Hexadecimal number ");		
		String firstNumber  = sc.nextLine();

		System.out.println("Enter second Hexadecimal number");
		String secondNumber = sc.nextLine();

		System.out.println("decimal of first number is"+ hexa.toDecimal(firstNumber));
		System.out.println("sum of both number in hexadecimal is "+hexa.add(firstNumber, secondNumber));
		System.out.println("difference of both the number is"+hexa.subtract(firstNumber, secondNumber));
		System.out.println("multiplication of both the number is "+hexa.multiply(firstNumber, secondNumber));
		System.out.println("division of both the number is"+hexa.divide(firstNumber, secondNumber));
		System.out.println("first number is equal to second "+hexa.isEqual(firstNumber, secondNumber));
		System.out.println("first number is greater to second "+hexa.isGreater(firstNumber, secondNumber));
		System.out.println("first number is less than to second "+hexa.isLesser(firstNumber, secondNumber));

		

	}

}
