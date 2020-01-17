import java.util.ArrayList;


public class ArrOperation {

	int countClumps(int[] array)
	{
		if(array.length==0)
			throw new AssertionError("empty array");
		int noOfClumps=0;
		for(int i=0;i<array.length-1;i++)
		{
			if(array[i] == array[i+1])
			{
				noOfClumps++;

				while(i < array.length-1 && array[i] == array[i+1])
				{
					i++;

				}
			}	
		}



		return noOfClumps;
	}

	int splitArray(int[] array)
	{
		if(array.length==0)
			throw new AssertionError("empty array");
		int sumForward = 0;
		int i;
		for(i = 0;i<array.length;i++)
		{
			sumForward+=array[i];
			int j = array.length -1;
			int sumBackward = 0;
			while(j>i)
			{
				sumBackward+=array[j];
				j--;
			}
			if(sumForward == sumBackward)

				break;
		}
		if(i>=0 && i<array.length)
			return i+1;
		return -1;
	}

	int[] fixXY(int[] array,int x,int y)
	{
		int noOfX=0;
		int noOfY=0;
		ArrayList<Integer> previousIndexOfY = new ArrayList<Integer>();
		for(int i=0;i<array.length;i++)
		{
			if(array[i]==x)
				noOfX++;
			if(array[i]==y)
				noOfY++;

		}



		if(array.length==0||noOfX!=noOfY||array[array.length-1]==x)
			throw new AssertionError("empty array");


		int indexOfX = 0,indexOfY = -1;
		for(int i=0;i<array.length;i++)
		{
			if(array[i] == x  )
			{
				indexOfX = i;
				int j=0;
				for( j=0;j<array.length;j++)
				{
					if(array[j]==y && !previousIndexOfY.contains(j))
						break;

				}
				indexOfY = j;

				int temp = array[indexOfY];
				array[indexOfY]=array[indexOfX+1];
				array[indexOfX+1]=temp;
				indexOfY = indexOfX +1;
				previousIndexOfY.add(indexOfY);

			}

		}

		return array;
	}
	int mirror(int[] arr)
	{	if(arr.length==0)
		throw new AssertionError("empty array");

	int size = arr.length;
	int max =0;
	int [][]matrix=new int[size+1][size+1];
	for(int i=0;i<=size;i++)
	{
		for(int j=0;j<=size;j++)
		{
			if(i==0||j==0)
			{
				matrix[i][j]=0;
			}
			else if(arr[i-1]==arr[size-j])
			{
				matrix[i][j]=matrix[i-1][j-1]+1;
			}
			else
			{
				matrix[i][j]=0;
			}
			if(max<matrix[i][j])
			{
				max=matrix[i][j];
			}

		}

	}
	return max;

	}


}
