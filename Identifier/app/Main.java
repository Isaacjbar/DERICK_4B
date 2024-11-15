import classifier.KNNClassifier;
import model.Node;
import structures.BinaryTree;
import utils.Trainer;

public class Main {
    public static void main(String[] args) {
        // Entrena el árbol con 100 datos de ejemplo
        BinaryTree<String> tree = Trainer.trainTree(100);

        // Crea el clasificador con K=3
        KNNClassifier<String> knnClassifier = new KNNClassifier<>(tree, 3);

        // Genera una nueva criatura para clasificar
        Node<String> newCreature = DataGenerator.generateRandomCreature();
        String species = knnClassifier.classify(newCreature);

        System.out.println("Predicted species: " + species);
    }
}
