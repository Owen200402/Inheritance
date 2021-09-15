package DataStructures.Queues;

import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    public static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        if (queue.isEmpty())
            throw new IllegalStateException();

        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.empty())
            queue.add(stack.pop());

        System.out.println(queue);
    }

    // Self implemented
    public static void reverse(Queue<Integer> queue, int k) {
        Stack<Integer> stack = new Stack<>();

        int size = queue.size();

        for (int i = 0; i < k; i++)
            stack.add(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());

        for (int i = 0; i < size - k; i++)
            queue.add(queue.remove());


        System.out.println(queue);
    }
}
