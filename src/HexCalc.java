

/**
 * 
 * @author Ayush
 * HexCalc is a class to perform various operations on hexadecimal numbers 
 * like addition,subtraction,multiplication,division of 2 hexadecimal number
 *
 */



class HexCalc {

	String hexnum="0123456789ABCDEF";

	/**
	 * add function adds 2 hexadecimal number and return addition in form of Hexadecimal number as String	
	 * assumption is made that both the number are positive integer
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return String
	 */

	String add(String firstNumber,String secondNumber)
	{
		int sum = Integer.parseInt(toDecimal(firstNumber)) + Integer.parseInt(toDecimal(secondNumber));

		return toHexaDecimal((Integer.toString(sum)));

	}
	/**
	 * subtract function subtract the first hexadecimal number by by second hexadecimal number
	 * and return hexadecimal number as String
	 * Assumption is made that first number is greater than second
	 * @param firstNumber
	 * @param secondNumber
	 * @return String
	 */
	String subtract(String firstNumber,String secondNumber)
	{
		int subtraction = Integer.parseInt(toDecimal(firstNumber)) - Integer.parseInt(toDecimal(secondNumber));

		return toHexaDecimal((Integer.toString(subtraction)));
	}
	/**
	 * multiply function multiplies two hexadecimal number and returns hexadecimal number in form of string
	 * @param firstNumber
	 * @param secondNumber
	 * @return String
	 */

	String multiply(String firstNumber,String secondNumber)
	{


		int multiplie = Integer.parseInt(toDecimal(firstNumber)) * Integer.parseInt(toDecimal(secondNumber));

		return toHexaDecimal((Integer.toString(multiplie)));
	}

	/**
	 * divide function divides the hexadecimal numbers and return the hexadecimal number in form of string
	 * @param firstNumber
	 * @param secondNumber
	 * @return	String
	 */
	String divide(String firstNumber,String secondNumber)
	{

		int division = Integer.parseInt(toDecimal(firstNumber)) / Integer.parseInt(toDecimal(secondNumber));

		return toHexaDecimal((Integer.toString(division)));
	}
	/**
	 * 
	 * @param number
	 * @return String
	 */

	String toDecimal(String number)
	{
		number=number.toUpperCase();
		int length=number.length();
		int decimal=0;
		float exponent=0;


		for(int i=length-1;i>=0;i--)
		{	

			if(hexnum.indexOf(number.charAt(i))>=0)    //indexOf returns index value if the char exists and return -1 if not exists
			{
				char character =  number.charAt(i);
				int  num       =  hexnum.indexOf(character);
				decimal 	   += num * (int)Math.pow(16, exponent); 

			}
			else
			{
				System.out.println("invalid input");
				break;
			}
			exponent++;

		}
		return Integer.toString(decimal);
	}
	/**
	 * this function convert the given decimal number to hexadecimal
	 * @param number
	 * @return String
	 */

	String toHexaDecimal(String number)
	{
		String hex = "";
		int reminder;
		int integerOfNumber = Integer.parseInt(number);
		while(integerOfNumber>0)
		{
			reminder=integerOfNumber % 16;
			hex = hexnum.charAt(reminder) + hex;
			integerOfNumber = integerOfNumber/16;
		}



		return hex;

	}

	/**
	 * this function returns true if the first number is greater than the second number else return false
	 * @param firstNumber
	 * @param secondNumber
	 * @return boolean
	 */
	boolean isGreater(String firstNumber,String secondNumber)
	{
		if(firstNumber.length()>secondNumber.length())
			return true;
		else if(firstNumber.length()==secondNumber.length())
		{	int flag=0;
		for(int i=0;i<firstNumber.length();i++)
		{
			if(firstNumber.charAt(i)>secondNumber.charAt(i))
			{
				return true;
			}
			else if(firstNumber.charAt(i)<secondNumber.charAt(i) )
			{
				return false;
			}
			else
			{
				continue;
			}

		}



		}

		return false;
	}

	/**
	 *this function returns true if the first number is less than the second number else return false
	 * @param firstNumber
	 * @param secondNumber
	 * @return boolean
	 */
	boolean isLesser(String firstNumber,String secondNumber)
	{
		if(!isEqual(firstNumber, secondNumber)&&!isGreater(firstNumber, secondNumber))
			return true;
		else
			return false;
	}

	/**
	 * this function returns true if the first number is equal to the second number else return false
	 * @param firstNumber
	 * @param secondNumber
	 * @return
	 */
	boolean isEqual(String firstNumber,String secondNumber)
	{
		if(firstNumber.length()!=secondNumber.length())
			return false;

		else if(firstNumber.length()==secondNumber.length())
		{	int flag=0;
		for(int i=0;i<firstNumber.length();i++)
		{
			if(firstNumber.charAt(i)==secondNumber.charAt(i))
			{
				continue;
			}
			else if(firstNumber.charAt(i)!=secondNumber.charAt(i) )
			{
				return false;
			}

		}



		
		}
		return true;


	}






}
