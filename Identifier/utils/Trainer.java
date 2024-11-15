import model.Node;
import structures.BinaryTree;
import model.DataGenerator;

public class Trainer {
    public static BinaryTree<String> trainTree(int numberOfDataPoints) {
        BinaryTree<String> tree = null;
        for (int i = 0; i < numberOfDataPoints; i++) {
            Node<String> creature = DataGenerator.generateRandomCreature();
            
            // Validar que las propiedades del nodo sean lógicas antes de agregarlo
            if (isConsistent(creature)) {
                if (tree == null) {
                    tree = new BinaryTree<>(creature);
                } else {
                    tree.insert(creature, "Size"); // El criterio puede ajustarse si es necesario
                }
            } else {
                System.out.println("Inconsistent data point detected, skipping...");
            }
        }
        return tree;
    }

    // Método de validación de coherencia
    private static boolean isConsistent(Node<String> node) {
        String species = node.getSpecies();
        String skinType = node.getProperty("Skin Type");
        
        // Validar coherencia según las especies y tipos de piel
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
