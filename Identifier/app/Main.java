
import classifier.KNNClassifier;
import model.Node;
import structures.BinaryTree;
import utils.Trainer;
import model.DataGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Entrenar el árbol con 100 datos de ejemplo
        BinaryTree<String> tree = Trainer.trainTree(100);
        
        // Crear el clasificador con K=3
        KNNClassifier<String> knnClassifier = new KNNClassifier<>(tree, 3);

        // Menú de opciones
        while (true) {
            System.out.println("\n--- Creature Identifier ---");
            System.out.println("1. Enter a new animal");
            System.out.println("2. Generate a random animal and show prediction");
            System.out.println("3. Show training data samples");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (option) {
                case 1:
                    Map<String, String> properties = new HashMap<>();

                    System.out.println("Enter the animal's characteristics:");
                    System.out.print("Size (Small, Medium, Large): ");
                    String size = scanner.nextLine();
                    properties.put("Size", size);

                    System.out.print("Skin Type (Fur, Scales, Feathers, etc.): ");
                    String skinType = scanner.nextLine();
                    properties.put("Skin Type", skinType);

                    System.out.print("Habitat (Land, Water, Air, etc.): ");
                    String habitat = scanner.nextLine();
                    properties.put("Habitat", habitat);

                    System.out.print("Diet (Herbivore, Carnivore, Omnivore, etc.): ");
                    String diet = scanner.nextLine();
                    properties.put("Diet", diet);

                    System.out.print("Behavior (Nocturnal, Diurnal, etc.): ");
                    String behavior = scanner.nextLine();
                    properties.put("Behavior", behavior);

                    Node<String> userCreature = new Node<>("Unknown", properties);
                    String predictedSpecies = knnClassifier.classify(userCreature);
                    System.out.println("Predicted species: " + predictedSpecies);
                    break;

                case 2:
                    Node<String> randomCreature = DataGenerator.generateRandomCreature();
                    System.out.println("Randomly generated animal:");
                    for (Map.Entry<String, String> entry : randomCreature.getProperties().entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    String randomPrediction = knnClassifier.classify(randomCreature);
                    System.out.println("Predicted species: " + randomPrediction);
                    break;

                case 3:
                    // Muestra ejemplos de datos de entrenamiento
                    System.out.println("Showing 5 training data samples:");
                    for (int i = 0; i < 5; i++) {
                        Node<String> sampleCreature = DataGenerator.generateRandomCreature();
                        System.out.println("Sample " + (i + 1) + ":");
                        for (Map.Entry<String, String> entry : sampleCreature.getProperties().entrySet()) {
                            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
                        }
                        System.out.println("  Species: " + sampleCreature.getSpecies());
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
