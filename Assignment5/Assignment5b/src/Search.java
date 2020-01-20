
 public class Search {
	 
	 static int index=0;
	 static int low = 0;
	 static int mid = 0;
	 static int high = 0;
	 int linearSearch(int[] array,int numberToSearch)
	 {
		 if(array[index]==numberToSearch)
			 return index;
		 else if(index!=array.length)
		 {
			 index++;
		 	return linearSearch(array, numberToSearch);
		 }
		 
		 
		 return -1;
		 
	 }
	 int binarySearch(int[] array,int firstIndex,int lastIndex,int numberTosearch)
	 {
		    if (lastIndex >= firstIndex) { 
		        int mid = firstIndex + (lastIndex - firstIndex) / 2; 
		  

		        if (array[mid] == numberTosearch) 
		            return mid; 
		  

		        if (array[mid] > numberTosearch) 
		            return binarySearch(array, low, mid - 1, numberTosearch); 
		  

		        return binarySearch(array, mid + 1, lastIndex, numberTosearch); 
		    } 
		  

		    return -1; 
		} 
		 
		 
		
	 

}
