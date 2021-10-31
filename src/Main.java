import DataStructures.AVLTrees.AVLTree;
import DataStructures.BinaryTrees.Tree;

public class Main {
    public static void main (String[] arg) {
        Tree tree = new Tree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(12);



        System.out.println(tree.isPerfect());
    }
}


