
import static org.junit.Assert.*;
import org.junit.Test;

public class TestMath {
	@Test
	public void testHcf()
	{
		int result;
		Maths maths = new Maths();
		result = maths.getHcf(5, 10);
		assertEquals(5, result);	
	}
	@Test
	public void testLcm()
	{
		int result;
		Maths maths = new Maths();
		result = maths.lcm(5, 10);
		assertEquals(10, result);	
	}
	

}
