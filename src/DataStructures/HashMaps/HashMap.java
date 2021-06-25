package DataStructures.HashMaps;

import java.util.Arrays;

public class HashMap {
    public static class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    Entry[] entries = new Entry[5];
    private int count;

    public void put(int key, String value) {
        int index = hash(key);

        for (int i = 0; i < entries.length; i++) {
            if (entries[index] == null) {
                entries[index] = new Entry(key, value);
                count++;
                return;
            }

            if (entries[index].key == key) {
                entries[index].value = value;
                return;
            }

            index++;
            if (index == entries.length)
                index = index % (entries.length);
        }
         throw new IllegalStateException("Array is full.");
    }

    public String get(int key) {
        int index = hash(key);

        for (int i = index; i < entries.length; i = (i+1) % entries.length) {
            if (entries[i] == null)
                return null;
            if (entries[i].key == key)
                return entries[i].value;
            else {
                index += 1;
            }
        }

        return null;
    }

    public void remove(int key) {
        int index = hash(key);

        for (int i = index; i < entries.length; i = (i+1) % entries.length) {
            if (entries[i] == null)
                throw new IllegalStateException();
            if (entries[i].key == key) {
                entries[i] = null;
                return;
            }
            else {
                index += 1;
            }
        }
        count--;
    }

    public int size() {
        return count;
    }

    private boolean isFull() {
        return count == entries.length;
    }

    private int hash(int key) {
        return key % entries.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }
}
