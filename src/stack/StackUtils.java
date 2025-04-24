package stack;

import java.util.Stack;

public class StackUtils {

    public static String reverseString(String text){

        if(text == null) return null;

        Stack<Character> stack = new Stack<Character>();
        String reversedString = "";

        for(char c : text.toCharArray()){
            stack.push(c);
        }

        while(!stack.isEmpty()){
            reversedString += stack.pop();
        }

        return reversedString;
    }

    public static boolean isBalancedParentheses(String parentheses){
        Stack<Character> stack = new Stack<>();
        for (char p : parentheses.toCharArray()) {
            if (p == '(') {
                stack.push(p);
            } else if (p == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }else{
                throw new RuntimeException("Input String is not valid, only ( and ) are accepted.");
            }
        }
        return stack.isEmpty();
    }
}
