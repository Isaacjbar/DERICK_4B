import model.Node;
import structures.BinaryTree;

public class Trainer {
    public static BinaryTree<String> trainTree(int numberOfDataPoints) {
        BinaryTree<String> tree = null;
        for (int i = 0; i < numberOfDataPoints; i++) {
            Node<String> creature = DataGenerator.generateRandomCreature();

            // Validate that the node's properties are logical before adding it
            if (isConsistent(creature)) {
                if (tree == null) {
                    tree = new BinaryTree<>(creature);
                } else {
                    tree.insert(creature, "Size"); // The criterion can be adjusted if needed
                }
            } else {
                System.out.println("Inconsistent data point detected, skipping...");
            }
        }
        return tree;
    }

    private static boolean isConsistent(Node<String> node) {
        String species = node.getSpecies();
        String skinType = node.getProperty("Skin Type");

        // Validate consistency based on species and skin type
        switch (species) {
            case "Mammal":
                return skinType.equals("Fur");
            case "Bird":
                return skinType.equals("Feathers");
            case "Reptile":
            case "Fish":
                return skinType.equals("Scales");
            case "Amphibian":
                return skinType.equals("Moist Skin");
            case "Invertebrate":
                return skinType.equals("Exoskeleton") || skinType.equals("Soft Body");
            default:
                return false;
        }
    }
}
