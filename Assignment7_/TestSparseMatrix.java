

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This class tests the sparse matrix class.
 */
public class TestSparseMatrix {

	/**
	 * Test for transpose of matrix.
	 */
	@Test
	public void TestSparseMtrix_transpose(){
		int[][] arr = 
			{{5,0,3},
				{2,0,0},
				{1,0,0}};
		SparseMatrix s1 = new SparseMatrix(arr);
		int[][] b = s1.transposeOfMatrix();
		boolean check = true;

		for(int i=0;i<arr.length;i++){
			for(int j=0;j<b[0].length;j++){
				if(arr[i][j]!=b[i][j])
					check = false;
			}
		}

		assertEquals(false,check);
	}

	/**
	 * Test for symmetry of matrix.
	 */
	@Test
	public void TestSparseMtrix_CheckSymmetry(){
		int[][] arr = 
			{{5,0,3},
				{2,0,0},
				{1,0,0}};
		SparseMatrix s1 = new SparseMatrix(arr);
		boolean check = s1.checkSymmetric();
		assertEquals(false,check);
	}

	/**
	 * Test for addition of matrix.
	 */
	@Test
	public void TestSparseMtrix_addMatrix(){
		int[][] arr = 
			{{0,1,0},
				{1,0,1},
				{0,1,0}};
		SparseMatrix s1 = new SparseMatrix(arr);

		int[][] brr = 
			{{0,1,0},
				{1,0,1},
				{0,0,0}};
		SparseMatrix s2 = new SparseMatrix(brr);

		int[][] crr = 
			{{0,2,0},
				{2,0,2},
				{0,1,0}};
		int[][] b = SparseMatrix.addMatrix(s1, s2);
		boolean check = true;

		for(int i=0;i<crr.length;i++){
			for(int j=0;j<crr[0].length;j++){
				if(crr[i][j]!=b[i][j])
					check = false;
				else
					check =true;
			}
		}

		assertEquals(true,check);
	}

	/**
	 * Test for multiplication of matrix.
	 */
	@Test
	public void TestSparseMtrix_multiplyMatrix(){
		int[][] arr = 
			{{5,0,3},
				{2,0,0,},
				{1,0,0}};
		SparseMatrix s1 = new SparseMatrix(arr);

		int[][] brr = 
			{{0,0,0,1},
				{2,3,0,0},
				{1,0,1,0}};
		SparseMatrix s2 = new SparseMatrix(brr);

		int[][] crr = 
			{{3,0,3,5},
				{0,0,0,2},
				{0,0,0,1}};
		int[][] b = SparseMatrix.multiplyMatrix(s1, s2);
		boolean check = true;

		for(int i=0;i<crr.length;i++){
			for(int j=0;j<crr[0].length;j++){
				if(crr[i][j]!=b[i][j])
					check = false;
				else
					check =true;
			}
		}

		assertEquals(true,check);
	}
}
