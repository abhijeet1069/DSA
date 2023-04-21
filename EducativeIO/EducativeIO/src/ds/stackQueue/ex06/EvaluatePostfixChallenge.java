package ds.stackQueue.ex06;

/**
 The input string contains a valid postfix expression. Operands are digits. Compute the postfix expression.
 Input:
 	expression = "921*-8-4+" # 9 - 2 * 1 - 8 + 4
 Output:
 	3
*/

public class EvaluatePostfixChallenge {

	public static int evaluatePostFix(String expression) {
        Stack<Integer> stack = new Stack<>(expression.length());
        for(int i = 0; i < expression.length(); i++) {
        	char ch = expression.charAt(i);
        	if(ch == '+') {
        		int num1 = stack.pop();
        		int num2 = stack.pop();
        		stack.push(num2+num1);
        	}
        	else if(ch == '-') {
        		int num1 = stack.pop();
        		int num2 = stack.pop();
        		stack.push(num2-num1);
        	}
        	else if(ch == '*') {
        		int num1 = stack.pop();
        		int num2 = stack.pop();
        		stack.push(num2*num1);
        	}
        	else if(ch == '/') {
        		int num1 = stack.pop();
        		int num2 = stack.pop();
        		stack.push(num2/num1);
        	}
        	else {
        		stack.push(Character.getNumericValue(ch));
        	}
        }
        return stack.pop();
    }
	
	public static void main(String[] args) {
		String str = "638*+4-";
		System.out.println(evaluatePostFix(str));
	}

}
