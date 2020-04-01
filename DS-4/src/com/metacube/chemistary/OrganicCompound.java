package com.metacube.chemistary;

/**
 * To calculate the mass of organic compound.
 * @author Ayush Pandey
 *
 */
public class OrganicCompound {
	private static int nOfC, nOfH, nOfO;

	/**
	 * To find the total occurance of C,Hand O in formulae
	 * @param str to be evaluated
	 * @param value to define the occurance of charcater not having any adjacent digit.
	 */
	static void massCalculate(String str, int value) {
		int i=0; 
		while (i < str.length()){
			char ch = str.charAt(i);
			if (ch == '('){
				String subString = "";
				while (str.charAt(++i) != ')')
					subString += str.charAt(i);
				if (Character.isDigit(str.charAt(++i))){
					int value1 = Integer.valueOf(str.charAt(i++))-'0';
					massCalculate(subString, value1);
				}
				else
					massCalculate(subString, value);
				ch = str.charAt(i);
			}

			if (ch == 'c'){
				if (Character.isDigit(str.charAt(i+1)) && str.charAt(i+1) != ' ')
					nOfC += (Integer.valueOf(str.charAt(i+1))-'0')*value;
				else
					nOfC += 1*value;
			}
			if (ch == 'o'){
				if (Character.isDigit(str.charAt(i+1)) && str.charAt(i+1) != ' ')
					nOfO += (Integer.valueOf(str.charAt(i+1))-'0')*value;
				else
					nOfO += 1*value;
			}
			if (ch == 'h'){
				if (Character.isDigit(str.charAt(i+1)) && str.charAt(i+1) != ' ')
					nOfH += (Integer.valueOf(str.charAt(i+1))-'0')*value;
				else
					nOfH += 1*value;
			}
			i++;
		}
	}

	/**
	 * To calculate the mass of formulae
	 * @param str to evaluated
	 * @return the mass 
	 */
	static int massFormula(String str) {
		massCalculate(str+" ", 1);
		int massOfCarbon=12, massOfHydrogen=1, massOfOxygen=16;
		return (massOfCarbon*nOfC + massOfHydrogen*nOfH + massOfOxygen*nOfO);
	}

	public static void main(String[] args){
		String str = "c2h3(ch3)4c2h4";
		System.out.println("molecular mass of compound is: "+ massFormula(str));
	}

}
