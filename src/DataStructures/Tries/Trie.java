package DataStructures.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

    private static class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        Node current = root;

        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);

            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null) {
            return false;
        }

        Node current = root;

        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }

        return current.isEndOfWord;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node root) {
        System.out.println(root.value);
        for (var child : root.getChildren())
            traverse(child);
    }

    public void remove(String word) {
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }

        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if (child == null)
            return;

        remove(child, word, index + 1);

        if (!child.isEndOfWord && !child.hasChildren())
            root.children.remove(ch);
    }

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();
        var lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, words);

        return words;
    }

    private void findWords(Node root, String prefix, List<String> words) {
        if (root == null)
            return;

        if (root.isEndOfWord)
            words.add(prefix);

        for (var child : root.getChildren())
            findWords(child, prefix + child.value, words);
    }

    private Node findLastNodeOf(String prefix) {
        if (prefix == null)
            return null;

        var current = root;
        for (var ch: prefix.toCharArray()) {
            var child = current.getChild(ch);
            if (child == null)
                return null;
            current = child;
        }
        return current;
    }

    public boolean containsRecursive(String word) {
        if (word == null)
            return false;

        return containsRecursive(root, word, 0);
    }

    private boolean containsRecursive(Node root, String word, int index) {
        if (index == word.length()) {
            return root.isEndOfWord;
        }

        char ch = word.charAt(index);
        Node current = root.getChild(ch);

        if (current == null)
            return false;

        return containsRecursive(current, word, index + 1);
    }

    public int countWords() {
        return countWords(root);
    }

    private int countWords(Node root) {
        int count = 0;

        if (root.isEndOfWord)
            count++;

        for (var child : root.getChildren()) {
            count += countWords(child);
        }

        return count;
    }

    // For-loop implementation
    //    public static String longestCommonPrefix(String[] array) {
//        String copy = "";
//
//        String str = getShortest(array);
//
//        for (int i = 0; i < str.length(); i++) {
//            String letter = str.substring(i, i + 1);
//            boolean containsLetter = true;
//
//            for (String s : array) {
//                if (!s.substring(i, i + 1).equals(letter)) {
//                    containsLetter = false;
//                    break;
//                }
//            }
//
//            if (containsLetter)
//                copy += letter;
//        }
//
//        return copy;
//    }

    // Trie implementation
    public static String longestCommonPrefix(String[] array) {
        if (array == null)
            return "";

        Trie trie = new Trie();
        for (String str : array)
            trie.insert(str);

        StringBuilder prefix = new StringBuilder();
        int maxChars = getShortest(array).length();
        Node current = trie.root;

        while (prefix.length() < maxChars) {
            if (current.getChildren().length > 1)
                break;
            current = current.getChildren()[0];
            prefix.append(current.value);
        }

        return prefix.toString();
    }

    private static String getShortest(String[] array) {
        if (array == null || array.length == 0) {
            return "";
        }

        String str = array[0];
        for (String item : array) {
            if (item.length() < str.length())
                str = item;
        }

        return str;
    }

}



