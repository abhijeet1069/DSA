package divideAndConquer;

public class MultiplySquareMatrix {

	public static int[][] multiplyMatrix(int[][] a, int[][] b) throws Exception{

		if(a.length != b.length) {
			throw new Exception("Please enter square matrices with same size");
		}
		
		int[][] res = new int[a.length][b.length];
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b.length; j++) {
				int sum = 0;
				for(int k = 0; k < b.length; k++) {
					sum += a[i][k] * b[k][j];
				}
				res[i][j] = sum;
			}
		}
		return res;
	}
	
	public static void printMatrix(int[][] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
		int[][] matA = new int[][] {{2,2,2,2},{2,2,3,2},{2,1,2,2},{2,6,2,8}};
		
		printMatrix(multiplyMatrix(matA,matA));
		}
	}