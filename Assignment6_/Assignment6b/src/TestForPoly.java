
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;



public class TestForPoly {
	Polynomial p1;
	Polynomial p2;
	Polynomial p3;
	Polynomial p4;
	@Before
	public void beforeTest()
	{
		p1 = new Polynomial(new double[]{4,2.5,1.3}, new double[]{3,2,1});
		p2 = new Polynomial(new double[]{4,2.5,1.3}, new double[]{3,2,1});
		p3 = new Polynomial(new double[]{2,1}, new double[]{2,1});
		p4 = new Polynomial(new double[]{1,1}, new double[]{2,1});
	}
	@Test
	public void testForSolve()
	{
		float result=p1.solveFor(4);
		assertEquals(301.2, result,5);
		
		result=p1.solveFor(5);
		assertEquals(569, result,5);


	}
	@Test
	public void testForDegree()
	{
		double result ;
		result =  p1.getDegree();
		
		assertEquals(3,result,5);
		
	}
	
	@Test
	public void testForAdd()
	{
		Polynomial result;
	
		result = Polynomial.add(p1, p2)	;
		//System.out.println(result.getCofficient()[]);
		assertArrayEquals(new double[]{8,5,2.6},result.getCofficient(),5);
		assertArrayEquals(new double[]{6,4,2},result.getexponent(),5);
		
	}
	@Test
	public void testForMul()
	{
		Polynomial result;
	
		result = Polynomial.multiply(p3, p4)	;
		assertArrayEquals(new double[]{2,2,1,1},result.getCofficient(),5);
		assertArrayEquals(new double[]{4,3,3,2},result.getexponent(),5);
		
	}


}
