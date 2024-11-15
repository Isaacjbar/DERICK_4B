import model.Node;
import structures.BinaryTree;
import model.DataGenerator;

public class Trainer {
    public static BinaryTree<String> trainTree(int numberOfDataPoints) {
        BinaryTree<String> tree = null;
        for (int i = 0; i < numberOfDataPoints; i++) {
            Node<String> creature = DataGenerator.generateRandomCreature();
            if (tree == null) {
                tree = new BinaryTree<>(creature);
            } else {
                tree.insert(creature, "Size"); // Adjust criterion as needed
            }
        }
        return tree;
    }
}
