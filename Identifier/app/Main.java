import classifier.KNNClassifier;
import model.Node;
import model.PredictionResult;
import structures.BinaryTree;
import utils.Trainer;
import model.DataGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Train the tree with sample data points
        BinaryTree<String> tree = Trainer.trainTree(100);
        
        // Create the classifier with K=3
        KNNClassifier<String> knnClassifier = new KNNClassifier<>(tree, 3);

        // Options menu
        while (true) {
            System.out.println("\n--- Creature Identifier ---");
            System.out.println("1. Enter a new animal");
            System.out.println("2. Generate a random animal and show prediction");
            System.out.println("3. Show training data samples");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Clear input buffer

            switch (option) {
                case 1:
                    Map<String, String> properties = new HashMap<>();
                    System.out.println("Enter the animal's characteristics:");

                    System.out.print("Size (Small, Medium, Large): ");
                    properties.put("Size", scanner.nextLine());

                    System.out.print("Skin Type (Fur, Scales, Feathers, etc.): ");
                    properties.put("Skin Type", scanner.nextLine());

                    System.out.print("Habitat (Land, Water, Air, etc.): ");
                    properties.put("Habitat", scanner.nextLine());

                    System.out.print("Diet (Herbivore, Carnivore, Omnivore, etc.): ");
                    properties.put("Diet", scanner.nextLine());

                    System.out.print("Behavior (Nocturnal, Diurnal, etc.): ");
                    properties.put("Behavior", scanner.nextLine());

                    System.out.print("Blood Type (Warm-blooded, Cold-blooded): ");
                    properties.put("Blood Type", scanner.nextLine());

                    System.out.print("Reproduction (Viviparous, Oviparous): ");
                    properties.put("Reproduction", scanner.nextLine());

                    System.out.print("Lifespan (Short, Medium, Long): ");
                    properties.put("Lifespan", scanner.nextLine());

                    System.out.print("Defense (Claws, Teeth, Venom, Camouflage, etc.): ");
                    properties.put("Defense", scanner.nextLine());

                    System.out.print("Sound (Roar, Chirp, Hiss, Croak, Buzz, Silent, etc.): ");
                    properties.put("Sound", scanner.nextLine());

                    System.out.print("Color Pattern (Uniform, Spotted, Striped, etc.): ");
                    properties.put("Color Pattern", scanner.nextLine());

                    Node<String> userCreature = new Node<>("Unknown", properties);
                    PredictionResult result = knnClassifier.classify(userCreature);
                    System.out.println("Predicted species: " + result);
                    break;

                case 2:
                    Node<String> randomCreature = DataGenerator.generateRandomCreature();
                    System.out.println("Randomly generated animal:");
                    for (Map.Entry<String, String> entry : randomCreature.getProperties().entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    PredictionResult randomResult = knnClassifier.classify(randomCreature);
                    System.out.println("Predicted species: " + randomResult);
                    break;

                case 3:
                    System.out.println("Showing 5 training data samples:");
                    for (int i = 0; i < 5; i++) {
                        Node<String> sampleCreature = DataGenerator.generateRandomCreature();
                        System.out.println("Sample " + (i + 1) + ":");
                        for (Map.Entry<String, String> entry : sampleCreature.getProperties().entrySet()) {
                            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
                        }
                        System.out.println("  Species: " + sampleCreature.getSpecies());
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
