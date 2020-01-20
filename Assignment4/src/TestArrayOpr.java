

import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayOpr {
	@Test
	public void testCaseForCountClumps() {
		ArrOperation aop = new ArrOperation();
		int res;
		res = aop.countClumps(new int[] {1,1,2,1,1});
		assertEquals(res,2);

		res = aop.countClumps(new int[] {1,1,1,1,1});
		assertEquals(res,1);

		res = aop.countClumps(new int[] {1,2,3,4});
		assertEquals(res,0);

		res = aop.countClumps(new int[] {1,2,3,4,5,5});
		assertEquals(res,1);

		res = aop.countClumps(new int[] {1,2,2,3,4});
		assertEquals(res,1);


		res = aop.countClumps(new int[] {1,2,3,3,5,5,6});
		assertEquals(res,2);
	}
	@Test
	public void testCaseForSplitArray()
	{

		ArrOperation aop = new ArrOperation();
		int result = aop.splitArray(new int[]{1,1,1,2,1 });
		assertEquals(result,3);

		result = aop.splitArray(new int[]{2,1,1,2,1 });
		assertEquals(result,-1);

		result = aop.splitArray(new int[]{10,10 });
		assertEquals(result,1);


	}

	@Test
	public void testCaseForfixXY()
	{

		ArrOperation aop = new ArrOperation();
		int result[] = aop.fixXY(new int[]{5,4,9,4,9,5 },4,5);
		int expected[]=new int[]{9, 4, 5, 4, 5, 9};
		assertArrayEquals(result,expected);

		result= aop.fixXY(new int[]{1,4,1,5},4,5);
		expected=new int[]{1,4,5,1};
		assertArrayEquals(result,expected);

		result= aop.fixXY(new int[]{1, 4, 1, 5, 5, 4, 1},4,5);
		expected=new int[]{1, 4, 5, 1, 1, 4, 5};
		assertArrayEquals(result,expected);

		result= aop.fixXY(new int[]{5,5,4,9,4,9,4,9,5},4,5);
		expected=new int[]{9,9,4,5,4,5,4,5,9};
		assertArrayEquals(result,expected);

	}
	@Test
	public void testCaseForMirror()
	{
		ArrOperation aop = new ArrOperation();
		int result = aop.mirror(new int[]{1, 2, 3, 8, 9, 3, 2, 1});
		assertEquals(result,3);
		result = aop.mirror(new int[]{7, 1, 4, 9, 7, 4, 1});
		assertEquals(result,2);
		result = aop.mirror(new int[]{1, 2, 1, 4});
		assertEquals(result,3);
		result = aop.mirror(new int[]{1, 4, 5, 3, 5, 4, 1});
		assertEquals(result,7);
	}

}




