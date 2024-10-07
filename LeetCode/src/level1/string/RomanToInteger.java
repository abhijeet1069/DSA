package level1.string;

import java.util.HashMap;
import java.util.Map;

/*
 * Trick : For Roman to Integer process from backward.
 * IV = 5-1
 * VI = 1+5 
 * */
public class RomanToInteger {

	public static int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int prev = 0, curr = 0;
        int sum = 0;
        for(int i = s.length()-1; i >= 0; i--) {
        	curr = map.getOrDefault(s.charAt(i),0);
        	if(curr >= prev)
        		sum += curr;
        	else
        		sum -= curr;
        	prev = curr;
        }
        return sum;
    }
	
	public static void main(String[] args) {
		String str = "MCMXCIV";
		System.out.println(romanToInt(str));
	}
}
