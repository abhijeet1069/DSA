package divideAndConquer;

//matrix of size 2^k , k belongs to Z+

public class RecMultiplySquareMatrix {

	public static void initializeMatrix(int[][] arr, int row, int col, int size) {
		int startRow = row*size;
		int startCol = col*size;

		for(int i = startRow; i < size+startRow; i++) {
			for(int j = startCol; j < size+startCol; j++) {
				//arr[i][j] = 
			}
		}
	}
	
	public static void recMultiply(int[][] a, int[][] b, int[][] c, int n) {
		if(n == 1) {
			c[0][0] = c[0][0] + a[0][0]*b[0][0];
			return;
		}
		int[][] a00 = new int[n/2][n/2];
		int[][] a01 = new int[n/2][n/2];
		int[][] a10 = new int[n/2][n/2];
		int[][] a11 = new int[n/2][n/2];
		
		int[][] b00 = new int[n/2][n/2];
		int[][] b01 = new int[n/2][n/2];
		int[][] b10 = new int[n/2][n/2];
		int[][] b11 = new int[n/2][n/2];
		
		int[][] c00 = new int[n/2][n/2];
		int[][] c01 = new int[n/2][n/2];
		int[][] c10 = new int[n/2][n/2];
		int[][] c11 = new int[n/2][n/2];
		
		recMultiply(a00,b00,c00,n/2);
		recMultiply(a00,b01,c01,n/2);
		recMultiply(a10,b00,c10,n/2);
		recMultiply(a10,b01,c11,n/2);
		
		recMultiply(a01,b10,c00,n/2);
		recMultiply(a01,b11,c01,n/2);
		recMultiply(a11,b10,c10,n/2);
		recMultiply(a11,b11,c11,n/2);
		
	}
	
	public static void printMatrix(int[][] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] A = new int[][] {{2,2},{2,2}};
		int[][] C = new int[][] {{0,0},{0,0}};
		int n = 2;
		
		recMultiply(A,A,C,n);
		printMatrix(C);
	}

}
