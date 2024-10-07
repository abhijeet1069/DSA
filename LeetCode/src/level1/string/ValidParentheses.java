package level1.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public static boolean isValid(String s) {
        Map<Character,Character> charMap = new HashMap<>();
        charMap.put(')','(');
        charMap.put('}','{');
        charMap.put(']','[');
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
        	if(!stack.empty() && charMap.get(s.charAt(i)) == stack.peek()) 
        		stack.pop();
        	else 
        		stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		String str = "(]";
		System.out.println(isValid(str));
	}
}
