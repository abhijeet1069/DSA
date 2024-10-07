package level1.string;

public class LongestCommonPrefix {

	private final static String BLANK = "";
	
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length < 2) 
			return BLANK;
		
		String minLenStr = strs[0];
		for(int i = 1; i < strs.length; i++) {
			if(strs[i].length() < minLenStr.length())
				minLenStr = strs[i];
		}
		
		String prefix = "";
		outerloop:
		for(int i = 0; i < minLenStr.length(); i++) {
			String currChar = BLANK+minLenStr.charAt(i);
			for(int j = 0; j < strs.length; j++) {
				if(!currChar.equalsIgnoreCase(BLANK+strs[j].charAt(i))) {
					currChar = BLANK;
					break outerloop;
				}
			}
			prefix += currChar;
		}
		return prefix;
	}
	
	public static void main(String[] args) {
		String[] strs = new String[] {"dog","racecar","car"};
		System.out.println(longestCommonPrefix(strs));
	}
}
