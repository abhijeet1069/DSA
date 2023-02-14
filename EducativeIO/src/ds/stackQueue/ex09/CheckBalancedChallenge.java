package ds.stackQueue.ex09;

import java.util.HashMap;
import java.util.Set;

public class CheckBalancedChallenge {
    public static boolean isBalanced(String exp) {
        Stack<Character> stack = new Stack<>(exp.length()); //just for the worst case
        
        HashMap<Character,Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Set<Character> keySet = map.keySet();
        
        for(int i = 0;i < exp.length(); i++) {
        	char ch = exp.charAt(i);
        	if(!keySet.contains(ch)) {
        		stack.push(ch);
        	}
        	else { //closing characters
        		if(stack.isEmpty()) { //closing character is present but nothing to pop
        			return false;
        		}
        		if(stack.top() == map.get(ch)) {
        			stack.pop();
        		}
        		else {
        			return false;
        		}
        	}
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String exp = "{[({})]}{}";
        System.out.println(isBalanced(exp));
    }
}
