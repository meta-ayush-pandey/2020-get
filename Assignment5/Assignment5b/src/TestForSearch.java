import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestForSearch {

		@Test
		public void testCaseForCountClumps() {
			Search search = new Search();
			int result;
			result = search.linearSearch(new int[] {1,1,2,1,1},2);
			assertEquals(2,result);
		}

}
