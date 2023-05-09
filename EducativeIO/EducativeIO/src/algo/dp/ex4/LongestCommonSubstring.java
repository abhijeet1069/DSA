package algo.dp.ex4;

/*
Given two strings, s1 and s2, write a function that finds and returns the length of the longest substring of 
s2 and s1 (if any exist).

Input:
	string1 = "www.educative.io/explore";
	string2 = "educative.io/edpresso";
	
Output:
	14
 * */

public class LongestCommonSubstring
{
	public static int LCSLength(String s1, String s2) {
		int s1Len = s1.length();
		int s2Len = s2.length();
		int[][] matrix = new int[s1Len][s2Len];
		int max = 0;
		for(int i = 0; i < s1Len; i++) {
			for(int j = 0; j < s2Len; j++) {
				if(i == 0 || j == 0) {
					matrix[i][j] = (s1.charAt(i)==s2.charAt(j)) ? 1 : 0;
				}
				else {
					if(s1.charAt(i)==s2.charAt(j)) {
						matrix[i][j] = matrix[i-1][j-1]+1;
					}
				}
				max = Math.max(max, matrix[i][j]);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		String string1 = "www.educative.io/explore";
		String string2 = "educative.io/edpresso";
		
		System.out.println(LCSLength(string1,string2));
	}
}
