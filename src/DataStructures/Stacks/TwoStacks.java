package DataStructures.Stacks;

import java.util.Arrays;

public class TwoStacks {
    private int count1;
    private int count2;
    private int[] items;

    public TwoStacks(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("The capacity has to be greater than zero.");
        }
        items = new int[capacity];
        count1 = -1;
        count2 = capacity;
    }

    public void push1(int item) {
        if (isFull1())
            throw new IllegalStateException();
        count1++;
        items[count1] = item;
    }

    public void push2(int item) {
        if (isFull2())
            throw new IllegalStateException();
        count2--;
        items[count2] = item;
    }

    public int peek1() {
        if (isEmpty1())
            throw new IllegalStateException();

        return items[count1--];
    }

    public int peek2() {
        if (isEmpty2())
            throw new IllegalStateException();

        return items[count2++];
    }

    public boolean isFull1() {
        return count1 + 1 == count2;
    }

    public boolean isFull2() {
        return count2 - 1 == count1;
    }

    public boolean isEmpty1() {
        return count1 == -1;
    }

    public boolean isEmpty2() {
        return count2 == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
