package DataStructures.Queues;

import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    public static void reverse(Queue<Integer> queue, int k) {
        if (queue.isEmpty())
            throw new IllegalStateException("The queue is empty");

        Stack<Integer> stack1 = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack1.push(queue.remove());
        }

        while (!stack1.isEmpty()) {
            queue.add(stack1.pop());
        }

        for (int i = 0; i < queue.size() - k ; i++) {
            queue.add(queue.remove());
        }
    }
}
