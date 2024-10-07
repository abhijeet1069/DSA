package level1.arrays;

public class PlusOne {

	private static boolean checkIfAllNine(int[] digits) {
		boolean res = true;
		for(int i = 0; i < digits.length; i++) {
			if(digits[i] != 9) {
				res = false;
				break;
			}
		}
		return res;
	}
	
	public static int[] plusOne(int[] digits) {
        if(digits[digits.length-1] != 9) {
        	digits[digits.length-1] = digits[digits.length-1]+1;
        	return digits;
        }
        else {
        	boolean allNine = checkIfAllNine(digits);
        	if(allNine) {
        		int[] res = new int[digits.length+1];
        		res[0] = 1;
        		return res;
        	}
        	else {
        		int carry = 1;
        		for(int i = digits.length-1; i >= 0; i--) {
        			if(digits[i] == 9) {
        				if(carry == 1) {
        					digits[i] = 0;
        					carry = 1;
        				}
        			}
        			else {
        				digits[i] = digits[i]+carry;
        				carry = 0;
        			}
        		}
        	}
        	return digits;
        }
    }
	
	public static void main(String[] args) {
		int[] digits = new int[] {4,3,2,1};
		int[] res = plusOne(digits);
		for(int i : res)
			System.out.print(i+" ");
		System.out.println();
	}

}
