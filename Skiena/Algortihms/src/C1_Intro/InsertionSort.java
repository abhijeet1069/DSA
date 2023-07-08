package C1_Intro;

public class InsertionSort {
	
	public static void swap(int[] arr) {
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {12,22};
		swap(arr);
		System.out.println("arr[0] : "+arr[0]+" arr[1] : "+arr[1]);
	}
}
