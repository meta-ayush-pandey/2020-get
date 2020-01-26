

/**
 * This class holds the methods to operate on sparse matrix.
 * @author Martand
 *
 */
public class SparseMatrix {

	private final SparseMatrixIndex[] matrixLoc; 	//array of objects(SparseMatrixIndex).
	private final int totalRow, totalCol; 			//dimension of sparse matrix.

	/**
	 * This constructor initializes the Array of object.
	 * @param sparseMatrix matrix provided by the user
	 * @throws AssertionError when counts of non-zero elements are than 0's.
	 */
	SparseMatrix(int[][] sparseMatrix) throws AssertionError{

		SparseMatrixIndex[] tempMatrixLoc;
		SparseMatrixIndex sparseObject;
		int counter = 0,k=0;
		totalRow = sparseMatrix.length;
		totalCol = sparseMatrix[0].length;

		// For checking its sparse matrix.
		for(int i = 0; i < sparseMatrix.length; i++){
			for(int j = 0; j< sparseMatrix[i].length;j++){
				if(sparseMatrix[i][j] != 0 && counter < (sparseMatrix.length * sparseMatrix[0].length )/2)
					counter++;						//compare no of 0's with non zero's.
				else if(counter > (sparseMatrix.length * sparseMatrix[0].length )/2)
					throw new AssertionError("number of zero's are less"); 
			}
		}

		tempMatrixLoc = new SparseMatrixIndex[counter];

		forloop:
			for(int i = 0; i < sparseMatrix.length; i++){
				for(int j = 0; j< sparseMatrix[i].length;j++){
					if(sparseMatrix[i][j] != 0){
						sparseObject = new SparseMatrixIndex(i, j, sparseMatrix[i][j]);
						tempMatrixLoc[k++] = sparseObject;
					}
					if(k>counter)
						break forloop;
				}
			}
		matrixLoc = tempMatrixLoc.clone();
	}

	/**
	 * This function finds the transpose of the matrix.
	 * @return the transpose of the matrix.
	 */
	public int[][] transposeOfMatrix(){ 				//swap column to row and vice-versa.
		int[][] newMatrix = new int[totalRow][totalCol];

		for(int i=0; i < matrixLoc.length; i++){
			newMatrix[matrixLoc[i].col][matrixLoc[i].row] = matrixLoc[i].value; 
		}

		return newMatrix;
	}

	/**
	 * This function checks whether two matrices are symmetric or not.
	 * @return true if symmetric else false.
	 */
	public boolean checkSymmetric(){ 					//if transpose of matrix == matrix => symmetric
		int i=0,j=0;
		for(i=0; i<matrixLoc.length; i++){
			for(j=0;j<matrixLoc.length; j++){
				if((matrixLoc[i].row == matrixLoc[j].col) && (matrixLoc[i].col == matrixLoc[j].row) &&(matrixLoc[i].value == matrixLoc[j].value))
					break;
			}
			if(j == matrixLoc.length) 					// if any of the pair not matches.
				return false;
		}
		return true;
	}

	/**
	 * This function adds two matrices. 
	 * @param sparseObj_1 first matrix to be added.
	 * @param sparseObj_2 second matrix to be added.
	 * @throws AssertionError when dimensions are different.
	 * @return the added matrix.
	 */
	public static int[][] addMatrix(SparseMatrix sparseObj_1, SparseMatrix sparseObj_2) throws AssertionError{
		if(sparseObj_1.totalCol != sparseObj_2.totalCol || sparseObj_1.totalRow != sparseObj_2.totalRow)
			throw new AssertionError("Dimensions are different");

		int[][] newMatrix = new int[sparseObj_1.totalRow][sparseObj_1.totalCol]; 

		for(int i=0; i<sparseObj_1.matrixLoc.length;i++){
			newMatrix[sparseObj_1.matrixLoc[i].row][sparseObj_1.matrixLoc[i].col] = sparseObj_1.matrixLoc[i].value; 
		}

		for(int i=0; i<sparseObj_2.matrixLoc.length;i++){
			newMatrix[sparseObj_2.matrixLoc[i].row][sparseObj_2.matrixLoc[i].col] += sparseObj_2.matrixLoc[i].value; 
		}
		return newMatrix;
	}

	/**
	 * This function multiplies two matrices.
	 * @param sparseObj_1 First matrix to multiply.
	 * @param sparseObj_2 second matrix to multiply.
	 * @return the added matrix.
	 * @throws AssertionError when obj.col != obj.row;
	 */
	public static int[][] multiplyMatrix(SparseMatrix sparseObj_1, SparseMatrix sparseObj_2) throws AssertionError{
		if(sparseObj_1.totalCol != sparseObj_2.totalRow)
			throw new AssertionError("Mismatch in dimensions of col*row of matrices.");

		int[][] newMatrix = new int[sparseObj_1.totalRow][sparseObj_2.totalCol];

		for(int i =0 ;i<sparseObj_1.matrixLoc.length;i++){
			for(int j=0;j<sparseObj_2.matrixLoc.length;j++){
				if(sparseObj_1.matrixLoc[i].col == sparseObj_2.matrixLoc[j].row)
					newMatrix[sparseObj_1.matrixLoc[i].row][sparseObj_2.matrixLoc[j].col] += sparseObj_1.matrixLoc[i].value * sparseObj_2.matrixLoc[j].value;
			}
		}
		return newMatrix;
	}

	/*	public void print(){
		for(int i=0;i<matrixLoc.length;i++){
			System.out.println("obj : " + i);
			System.out.println("row : "+matrixLoc[i].row + " col : " + matrixLoc[i].col + " value : "+matrixLoc[i].value);
		}
	}

	public static void main(String[] args){
		int[][] arr = 
				{{5,0,3},
				{2,0,0},
				{1,0,0}};
		SparseMatrix s1 = new SparseMatrix(arr);
		int[][] b = s1.transposeOfMatrix();

		for(int i=0;i<b.length;i++){
			for(int j=0; j<b[0].length;j++){
				System.out.print(" " + b[i][j] + " ");
			}
			System.out.println();
		}

		int[][] brr = 
			{{0,0,0,1},
			{2,3,0,0},
			{1,0,1,0}};
		SparseMatrix s2 = new SparseMatrix(brr);

		boolean check = s1.checkSymmetric();
		System.out.println(check);

		b = s1.addMatrix(s1, s2);
		for(int i=0;i<b.length;i++){
			for(int j=0; j<b[0].length;j++){
				System.out.print(" " + b[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("---------multiply----------");
		b = s1.multiplyMatrix(s1, s2);
		for(int i=0;i<b.length;i++){
			for(int j=0; j<b[0].length;j++){
				System.out.print(" " + b[i][j] + " ");
			}
			System.out.println();
		}
	}*/
}
