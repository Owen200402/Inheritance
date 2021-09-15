package DataStructures.Stacks;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if (input == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

//        Old way:
//        for (int i = 0; i < input.length(); i++)
//            stack.push(input.charAt(i));


//        Better way:
        for (char ch : input.toCharArray())
            stack.push(ch);


//        Strings are immutable, that's why we use StringBuffer class to implement this scenario
        StringBuffer reversed = new StringBuffer();
        while (!stack.empty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
}
