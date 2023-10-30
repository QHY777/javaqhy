package third_String_Matrix;

public class SparseMatrix_Test {

	     public static void main(String[] args) {
	    	 int mat[][]= {{1,0,0,0,0},{0,2,0,0,0,},{0,0,3,0,0 }};
	    	 SparseMatrix L=new SparseMatrix(mat);
	    	 L.printMatrix();
		}
}
