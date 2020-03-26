/**
 * 
 * @author Ayush
 *	
 */

/*representation of link list using a class , link list contain a head and nodes so further node 
 * contain next node's refernece and data part so the node is made inner class of linklist
 * 
*/
class Linklist 
{
	Node head = null; 
	class Node		
	{ 
		int data; 
		Node next = null; 
		Node(int data) 
		{
			this.data = data; 
		} 
	} 
	
	/**
	 * 
	 * @param data takes input data to be inserted
	 * @return true if insertion is successful
	 */

	boolean insert (int data)
	{	Node node = new Node (data);
	try
	{
		if (head == null)
		{
			head = node;
		}
		else
		{	Node temp = head;
		while (temp.next != null)
		{
			temp = temp.next;
		}
		temp.next = node;

		}

	}
	catch (Exception e)
	{
		return false;
	}
	return true;


	}
	
	/**
	 * takes input as data to be deleted
	 * @param data
	 * @return true if element is found and deleted and false if not found or on unsuccessful deletion 
	 */
	
	boolean delete (int data)
	{
		boolean elementFound = false;
		try
		{
			Node temp = head;
			Node previousNode = null;

			while (temp != null) 
			{
				if (temp.data == data)
				{	elementFound = true;
				if (previousNode == null) 
				{
					head = temp.next;
				}

				else 
				{
					previousNode.next = temp.next;
				}

				break;
				}
				previousNode = temp;
				temp = temp.next;
			}

		}
		catch (Exception e)
		{
			return false;
		}
		return elementFound;
	}
	
	/**
	 * funtion to display linklist
	 */
	void display ()
	{	Node temp = head;
		while (temp!=null)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	/**
	 * function to get no of nodes in linklist
	 * @return size (no of nodes) integer value
	 */
	public int getSize() {
		int size = 0;
		Node temp = head;
		while (temp != null)
		{
			size++;
			temp = temp.next;
			
		}
		
		return size;
	}
	

}


