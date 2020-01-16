/**
 * Class Marksheet have  functions to find the average , maximum , minimum grades and percent of students passed 
 * @author Ayush
 *
 */
class Marksheet {
	
	/**
	 * this function takes array of double as input and calculate average of all grade and return it
	 * @param grades
	 * @return
	 */
	double average(double[] grades) 
	{
		float average;
		int total = 0;
		for(double i:grades)
		{
			total += i;
		}
		return total/grades.length;
		
	}
	
	/**
	 * this function takes double array as input and return maximum grade from it
	 * @param grades
	 * @return
	 */
	double maxGrade(double[] grades)
	{
		double maxGrdae=grades[0];
		for(double i:grades)
		{
			if(i>maxGrdae)
				maxGrdae = i;
		}
		return maxGrdae;
	}
	
	/**
	 * this function take grades double array as input and find minimum grade from it
	 * @param grades
	 * @return
	 */
	
	double minGrade(double[] grades)
	{
		double minGrdae=grades[0];
		for(double i:grades)
		{
			if(i<minGrdae)
				minGrdae = i;
		}
		return minGrdae;
	}
	/**
	 * takes grades as double array input and return the 
	 * % of students passed 
	 * pass means if grade>=40
	 * @param grades
	 * @return
	 */
	double	percentPass(double[] grades)
	{
		double percent;
		double noOfPassed=0;
		
		for(double i:grades)
		{
			System.out.println(i);
			if(i>=40)
			{
				noOfPassed++;
				
			}
				
		}
		
		percent = ((double)(noOfPassed/grades.length))*100;
		return percent;
	}
	
	
	

}
