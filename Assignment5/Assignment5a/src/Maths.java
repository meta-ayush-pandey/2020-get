/**
 * This class is used to find the lcm, hcf of two numbers
 * 
 * @author Ayush
 *
 */
public class Maths {
	static int common=1; // for lcm we have to declare a static variable to check from 1 to t=least number which can divide both the number
	
	/**
	 * this function takes 2 integer number as input and return the hcf of those number recursively as integer form
	 * @param number1
	 * @param number2
	 * @return
	 */
	int getHcf(int number1,int number2)
	{ 

		if (number2 != 0)
			return getHcf(number2, number1 % number2);
		else					// base condition
			return number1;
	}

	/**
	 * this function takes 2 number as input and return the lcm of those number recursively
	 * @param a
	 * @param b
	 * @return
	 */
	int lcm(int number1, int number2)
	{ 

		if (common % number1 == 0 && common % number2 == 0) // base condition 
		{
			return common;
		}
		common++;
		lcm(number1, number2);
		return common;
	}
}
