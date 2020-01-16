/**
 * class MyString have functions to calculate length of string
 * to check if 2 strings are equal or not
 * to reverse the string 
 * to change cases from upper to lower and vice versa in a string
 * to find largest word in the string
 * @author Ayush
 *
 */
class MyString {

	/**
	 * this function check the equality of 2 strings 
	 * if they are equal it return 1, else 0
	 * @param first
	 * @param second
	 * @return
	 */
	int isEqual(String first,String second)
	{
		int i=0;
		if(first.length() != second.length())
		{
			return 0;
		}
		while(i != first.length())
		{

			if(first.charAt(i) != second.charAt(i))
				return 0;
			i++;

		}
		return 1;
	}
	/**
	 * this function reverse the string
	 * @param string
	 * @return reverse of input string
	 */
	String reverse(String string)
	{	
		String reverse=""; //empty string to store the reverse of the string 
		for(int i=string.length()-1;i>=0;i--)
		{
			reverse+=string.charAt(i);

		}

		return reverse;
	}
	/**
	 * this function takes a string input and change its upper case in lower and vice versa
	 * @param string
	 * @return the string with case inverted
	 */
	String changeCases(String string)
	{ 	
		String caseInverted=""; //empty string to save the inverted case string
		for(int i=0;i<string.length();i++)
		{	int ascii=(int)string.charAt(i);
		if(ascii>=97&&ascii<=122)
		{
			caseInverted+=(char)((int)string.charAt(i)-32); //lower to upper case

		}
		else if(ascii>=65&&ascii<=90)
		{
			caseInverted+=(char)((int)string.charAt(i)+32); //upper to lower case

		}
		else
			caseInverted+=string.charAt(i);
		}
		return caseInverted;

	}

	/**
	 * this function takes a string as input and return the maximum length word from that string
	 * @param string
	 * @return word having max length in input string
	 * 
	 */

	String largestWord(String string)
	{	
		string += " ";          //append the space at last to take last word while splitting string from whitespace  
		String arrayOfAllWords[];

		int noOfWords=0;

		for(int i=0;i<string.length();i++)
		{
			if(string.charAt(i)==' ')
				noOfWords++;
		}

		int index=0;

		arrayOfAllWords=new String[noOfWords];
		arrayOfAllWords[0]=""; //Initializing array with empty string
		for(int i=0;i<string.length()-1;i++)
		{	
			if(string.charAt(i)!=' ')
			{
				arrayOfAllWords[index]+=string.charAt(i);
			}
			else{
				index++;
				arrayOfAllWords[index]="";  // Initializing array with empty string
			}

		}


		int max=0;
		for(int i=0;i<noOfWords;i++)
		{
			if(arrayOfAllWords[i].length()>=arrayOfAllWords[max].length())
				max=i;

		}

		return arrayOfAllWords[max];

	}


}
