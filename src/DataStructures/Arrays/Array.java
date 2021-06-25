package DataStructures.Arrays;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        if (items.length == count) {
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++)
                newItems[i] = items[i];

            items = newItems;
        }

        items[count] = item;
        count++;
    }

    public void removeAt(int index) {
        if (index < 0 || index > count - 1)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i+1];

        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item)
                return i;
        }
        return -1;
    }

    public int max() {
        int max = 0;

        for (int i = 0; i < count; i++) {
            if (max < items[i])
                max = items[i];
        }
        return max;
    }

    public int[] reverse() { //self-implemented
        int[] newArray = new int[count];

        for (int i = 0; i < count; i++) {
            newArray[i] = items[count - 1 - i];
        }

        return newArray;
    }

    public void insertAt(int item, int index) { // self-implemented
        if (index < 0 || index > count)
            throw new IllegalArgumentException();

        count++;
        for (int i = count; i > index; i--) {
            items[i] = items[i-1];
        }

        items[index] = item;
    }

    public void print(){
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}
