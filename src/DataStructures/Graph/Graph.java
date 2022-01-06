package DataStructures.Graph;

import java.util.*;

public class Graph {
    public static class Node {
        String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> list = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);

        List<Node> linkedList = new ArrayList<>();
        list.putIfAbsent(node, linkedList);
    }

    public void addEdge(String from, String to) {
        Node target = nodes.get(from);
        Node destination = nodes.get(to);

        if (target == null || destination == null)
            throw new IllegalArgumentException();

        list.get(target).add(destination);
          // Undirected graph
//        list.get(destination).add(target);
    }

    public void removeNode(String label) {
        Node node = nodes.get(label);

        if (node == null)
            return;

        for (var item : list.keySet()) {
            list.get(item).remove(node);
        }

        list.remove(node);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        Node nodeFrom = nodes.get(from);
        Node nodeTo = nodes.get(to);

        if (nodeFrom == null || nodeTo == null)
            return;

        list.get(nodeFrom).remove(nodeTo);
    }

    public void print() {
        for (var source : list.keySet()) {
            var targets = list.get(source);
            if (!targets.isEmpty()) {
                System.out.println(source + " is connected to " + targets);
            }
        }
    }

    public void traverseDepthFirstRec(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;

        Set<Node> set = new HashSet<>();
        traverseDepthFirstRec(node, set);
    }

    private void traverseDepthFirstRec(Node node, Set<Node> visited) {
        System.out.println(node);
        visited.add(node);

        for (var item : list.get(node)) {
            if (!visited.contains(item))
                traverseDepthFirstRec(item, visited);
        }
    }

    public void traverseDepthFirst(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;

        Set<Node> visited = new HashSet<>();

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.empty()) {
            Node current = stack.pop();
            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (var item : list.get(current))
                if (!visited.contains(item))
                    stack.push(item);
        }
    }

    public void traverseBreadthFirst(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;

        Queue<Node> queue = new ArrayDeque<>();

        Set<Node> visited = new HashSet<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (var item : list.get(current)) {
                if (!visited.contains(item))
                    queue.add(item);
            }
        }
    }

    public List<String> topologicalSort() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for (var node : nodes.values())
            topologicalSort(node, visited, stack);

        List<String> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop().label);
        }

        return list;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(node))
            return;

        visited.add(node);

        for (var item : list.get(node))
            topologicalSort(item, visited, stack);

        stack.push(node);
    }

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while(!all.isEmpty()) {
            var current = all.iterator().next();
            if (hasCycle(current, all, visiting, visited))
                return true;
        }

        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        for (var neighbour : list.get(node)) {
            if (visiting.contains(neighbour))
                return true;
            if (visited.contains(neighbour))
                continue;

            if (hasCycle(neighbour, all, visiting, visited))
                return true;
        }
        visiting.remove(node);
        visited.add(node);

        return false;
    }
}
