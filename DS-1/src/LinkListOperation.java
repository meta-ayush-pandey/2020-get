import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 
 * @author Ayush
 *
 */

/**
 *  class to perform various operations on linklist
 *
 */
public class LinkListOperation {
	
	/**
	 * function to perform rotation 
	 * @param linklist linklist whose nodes to be rotated 
	 * @param left     the left postion of node for starting rotation
	 * @param right		the right postion of node for starting rotation	
	 * @param rotation	number of rotation
	 * @return			linklist after rotation in nodes
	 */	
	
	
	Linklist rotate(Linklist linklist,int left,int right,int rotation)
	{	

		if(left >= right || right > linklist.getSize())
		{
			System.out.println("invalid inputs for left or right ");
			return null;
		}
		int actualRotation = rotation % (right-left + 1);
		System.out.println("actual roatation is " +actualRotation );

		Linklist.Node previousOfLeft = null;
		Linklist.Node leftNode = null;
		Linklist.Node previousOfRight = null;
		Linklist.Node rightNode = null;

		while (actualRotation != 0)
		{
			Linklist.Node temp = linklist.head;

			for (int i = 1; i <= right; i++)
			{	
				if (i == left-1)
				{
					previousOfLeft = temp;
				}
				if (i == left)
				{
					leftNode = temp;
				}
				if (i == right-1)
				{
					previousOfRight = temp;
				}
				if (i == right)
				{
					rightNode = temp;
					break;
				}

				temp = temp.next;

			}
			if(left == 1)
			{
				linklist.head = rightNode;
			}
			else
				previousOfLeft.next = rightNode;
			previousOfRight.next =rightNode.next;
			rightNode.next = leftNode;

			actualRotation--;
			temp = temp.next;

		}



		return linklist;

	}
	
	/**
	 * funtion to find out if a linklist has loop
	 * @param linklist takes input linklist
	 * @return true if it has loops and false if not
	 */
	
	
	boolean hasLoop(Linklist linklist)
	{
		boolean hasloop = false;
		List<Linklist.Node> traversedNodes = new ArrayList<Linklist.Node>();
		Linklist.Node temp = linklist.head;
		
		while (temp != null)
		{
	
			if(traversedNodes.contains(temp))
			{
				hasloop = true;
				break;
			}
			traversedNodes.add(temp);
			temp = temp.next;
		}

		return hasloop;
	}
	

	
	public static void main(String[] args)
	{
		Linklist l = new Linklist();
		l.insert(5);
		l.insert(4);
		l.insert(3);
		l.insert(2);
		l.insert(1);
		l.insert(9);
		System.out.println("before roataion the link list is ");
		l.display();
		System.out.println("size of link list is "+l.getSize());
		LinkListOperation opr = new LinkListOperation();
		System.out.println("after roatation is ");
		opr.rotate(l, 1, 6, 2).display();
		
		
		l.head.next.next.next = l.head.next;  // to create loop in linklist 
		System.out.println(opr.hasLoop(l));

	}



}
