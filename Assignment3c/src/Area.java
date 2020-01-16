/**
 * Area class has various functions to calculate are of triangle,square,circle and rectangle
 * @author Ayush
 *
 */
 class Area {
	 
	 final double Pi = 3.1415926536;  // constant to pi for area of circle 
	 	
	 double areaOfTriangle(double width,double height)
	 {
		 return 0.5 * width * height;
	 }
	 
	  double areaOfRecatangle(double width,double height)
	  {
		  return width * height;
	  }
	  double areaOfSquare(double side)
	  {
		  return side * side;
	  }
	  double areaOfCircle(double radius)
	  {
		  return Pi * radius * radius;
	  }
}
