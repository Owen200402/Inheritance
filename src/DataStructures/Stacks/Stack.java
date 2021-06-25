package DataStructures.Stacks;

import java.util.Arrays;

public class Stack {
    private int[] items = new int[5];
    private int count;

    public void push(int item) {
        if (count == items.length)
            throw new StackOverflowError();
        items[count] = item;
        count++;
    }

    public int pop() {
        if (count == 0)
            throw new IllegalStateException();

        count--;
        return items[count];
    }

    public int peek() {
        if (count == 0)
            throw new IllegalStateException();

        return items[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int min() {
        if (count == 0)
            throw new IllegalStateException();

        int min = items[0];

        for (int i = 0; i < count; i++) {
            if (items[i] < min)
                min = items[i];
        }

        return min;
    }

    @Override
    public String toString() {
        var content= Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }
}
