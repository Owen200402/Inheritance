import DataStructures.Graph.Graph;

public class Main {
    public static void main (String[] arg) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("D", "C");
        graph.addEdge("D", "A");

        System.out.println(graph.hasCycle());
    }
}


