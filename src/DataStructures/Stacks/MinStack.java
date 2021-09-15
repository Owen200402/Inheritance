package DataStructures.Stacks;

import java.util.Stack;

// We need two stacks to implement a min stack.
// One stack holds the values, the other stack
// (called minStack) holds the minimums.
public class MinStack {
    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public void push(int item) {
        stack.push(item);

        if (minStack.isEmpty())
            minStack.push(item);
        else if (item < minStack.peek())
            minStack.push(item);

    }

    public int pop() {
        if (stack.isEmpty())
            throw new IllegalStateException();

        if (stack.peek() == minStack.peek())
            minStack.pop();

        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
