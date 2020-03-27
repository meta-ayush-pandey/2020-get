
public class Main {
	
	public static void main(String[] args)
	{

		String expression = "3*2+5+(8*2)";
		
		if(Expression.create(expression))
		{
			Expression.display();
			Postfix.calculate();
			Postfix.displayPost();
			System.out.println("\nExpression Result : "+Postfix.answer());
		}
		else
		{
			System.out.println("Wrong Mathematical Expression");
		}

		System.out.print("Direct Result : ");
		System.out.println(3*2+5+(8*2));
	}
}
