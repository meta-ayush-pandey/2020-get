/**
 * class expression to perform various operation 
 * @author Ayush
 *
 */

public class Expression 
{
	static Node startNode = null;
	static int length = 0;

	/**
	 * function to create a node 
	 * 
	 * @param data takes a string input to add in node 
	 */

	public static void addNode(String data)
	{
		Node newNode = new Node(data);
		length++;
		Node tempNode;
		if (startNode == null)
			startNode = newNode;
		else 
		{
			tempNode = startNode;
			while (tempNode.next != null)
				tempNode = tempNode.next;
			tempNode.next = newNode;
		}
	}


	/**
	 * this function is to validate the expression 
	 * this function ignores the space in between the operands and opearator 
	 * this function rejects string if the expression is not valid
	 * @param string
	 * @return true if exprssion is valid
	 */
	public static boolean create(String string)
	{
		int length = string.length();
		int index = 0;

		while (index < length)
		{
			String temp = "";
			if (string.charAt(index) == ' ')
			{
				index++;
				continue;
			}
			if (string.charAt(index) >= '0' && string.charAt(index) <= '9')
			{
				temp += string.charAt(index);
				index++;
				while (index < length)
				{
					if (string.charAt(index) >= '0'
							&& string.charAt(index) <= '9') 
					{
						temp += string.charAt(index);
						index++;
					}
					else
					{
						while(string.charAt(index) == ' ')
						{
							if(index < length-1)
							{
								if(string.charAt(index) == ' ' && string.charAt(index+1) >= '0' && string.charAt(index+1) <= '9' )
								{
									return false;
								}
								index++;
							}
						}
						break;
					}
				}
			}
			else 
			{
				temp += string.charAt(index);
				index++;
			}
			addNode(temp);
		}
		return true;

	}

	/**
	 * this function display the mathematical expression entered by you
	 * 
	 */
	public static void display() 
	{
		Node tempNode = startNode;
		System.out.println("Your Mathematical Expression");
		while (tempNode != null) 
		{
			System.out.print(tempNode.data + " ");
			tempNode = tempNode.next;
		}
		System.out.println("\n");
	}

}
