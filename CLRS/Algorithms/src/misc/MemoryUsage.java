package misc;

public class MemoryUsage {

	public static void main(String[] args) {
		long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		
		int size = 100;
		int[] arr = new int[size];
		
		long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		System.out.println("Actual memory used: "+(afterUsedMem-beforeUsedMem));
	}
}
