
import DataStructures.Graph.WeightedGraph;

public class Main {
    public static void main (String[] arg) {
        var graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("A", "C", 1);
        graph.addEdge("C", "D", 5);
        graph.addEdge("B", "D", 4);
        var tree = graph.getMinimumSpanningTree();
        tree.print();
    }
}


