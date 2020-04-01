package com.metacube.uniqueness;

import java.util.HashMap;

/**
 * To find unique characters in string.
 * @author Ayush Pandey
 *
 */
public class StringOpertion {
	private static HashMap<String, Integer> calculatedResult = new HashMap<>();

	/**
	 * To find unique characters present in string
	 * @param str to be evaluated
	 * @return int total unique characters
	 */
	static int calculateUniqueCharacter(String str) {
		if(str == null)
			return -1;
		if (!calculatedResult.containsKey(str))
		{
			String newString = "";
			newString += str.charAt(0);
			for (int i=1; i<str.length(); i++){
				String temp = "";
				temp += str.charAt(i);
				if (!newString.contains(temp))
					newString += str.charAt(i);
			}
			calculatedResult.put(str, newString.length());
		}	
		return calculatedResult.get(str);
	}

	/**
	 * Driver function for calculating unique characters
	 * @param args
	 */
	public static void main(String[] args){
		String str = "hello";
		System.out.println(calculateUniqueCharacter(str));
		System.out.println(calculateUniqueCharacter("hello"));
		System.out.println(calculateUniqueCharacter("martand"));
		System.out.println(calculateUniqueCharacter("boomkaboom"));
		System.out.println(calculateUniqueCharacter("martand"));	
		System.out.println(calculateUniqueCharacter("tubelight"));	
	}
}
