package ds.stackQueue.ex09;

public class CheckBalancedChallenge {
    public static boolean isBalanced(String exp) {
        Stack<Character> stack = new Stack<>(exp.length()); //just for the rough case
        int len = exp.length();
        for(int i = 0; i < len; i++){
            char ch = exp.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else if(ch == '}' && !stack.isEmpty()){
                if(stack.top() == '{'){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else if(ch == ')' && !stack.isEmpty()){
                if(stack.top() == '('){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else if(ch == ']' && !stack.isEmpty()){
                if(stack.top() == '['){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String exp = "{[({})]}";
        System.out.println(isBalanced(exp));
    }
}
