package algo.dp.th1;

//finding path on an m*n grid

public class FindPath {
	
	public static int findPath(int m, int n, int[][] grid) {
		if(grid[m-1][n-1] != 0) {
			return grid[m-1][n-1];
		}
		else {
			if(m == 0 || n == 0) {
				grid[m-1][n-1] = 0;
				return 0;
			}
			
			if(m == 1 || n == 1) {
				grid[m-1][n-1] = 1;
				return 1;
			}
			
			int temp = findPath(m-1,n,grid) + findPath(m,n-1,grid);
			grid[m-1][n-1] = temp;
		}
		
		 return grid[m-1][n-1];
	}

	public static void main(String[] args) {
		int m = 50;
		int n = 50;
		int[][] grid = new int[m][n];
		System.out.println(findPath(m,n,grid));
	}
}
