package intro;

public class InsertionSort {

	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			while(j > 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j-1;
				arr[j+1] = key;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,0,4,2,1,0,88,3,44};
		insertionSort(arr);
		
		for(int x : arr) {
			System.out.print(x+" ");
		}
	}

}
