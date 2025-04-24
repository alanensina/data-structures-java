package stack;

public class Main {

    public static void main(String[] args) {

        Stack stack = new Stack(10);
        stack.push(15);
        stack.push(11);

        Stack.Node removedNode = stack.pop();
        stack.print();

        System.out.println("Removed Node: " + removedNode.value);
        System.out.println("Node peeked (but not removed): " + stack.peek().value);

        System.out.println("----------");
        String reversedString = StackUtils.reverseString("Alan Ensina");
        System.out.println(reversedString);

        String parenthesis = "()()()()()";
        System.out.println(StackUtils.isBalancedParentheses(parenthesis));
        parenthesis = "(()()))";
        System.out.println(StackUtils.isBalancedParentheses(parenthesis));

    }
}
