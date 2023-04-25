package c1elements.s5inputOutput.exercises;

public class LongestRun {

	public static void longestRun(int[] arr) {
		int run = 1, longestRun = 1, consecutive = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] == arr[i-1]) {
				run++;
				if(run > longestRun) {
					longestRun = run;
					consecutive = arr[i];
				}
			}
			else {
				run = 1;
			}
		}
		System.out.println("Longest run: "+longestRun+" Consecutive: "+consecutive);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 2, 1, 5, 1, 1, 7, 7, 7, 7, 7, 1, 1};
		longestRun(arr);
	}

}
