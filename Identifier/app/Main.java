
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to generate a sample CSV file for training? (yes/no): ");
        String generateCSV = scanner.nextLine().toLowerCase();

        if (generateCSV.equals("yes")) {
            System.out.print("Enter the path to save the CSV file: ");
            String filePath = scanner.nextLine();
            System.out.print("Enter the number of data points to generate: ");
            int numberOfDataPoints = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            Trainer.generateCSVSample(filePath, numberOfDataPoints);
        }

        // Select training data source
        System.out.println("Choose training data source:");
        System.out.println("1. Generate random data");
        System.out.println("2. Load data from CSV");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        BinaryTree<String> tree = null;

        if (choice == 1) {
            System.out.println("Training the binary tree with 100 data points...");
            tree = Trainer.trainTree(100);
        } else if (choice == 2) {
            System.out.print("Enter the path to the CSV file: ");
            String filePath = scanner.nextLine();
            System.out.println("Training the binary tree with data from CSV...");
            tree = Trainer.trainTreeFromCSV(filePath);
        } else {
            System.out.println("Invalid choice. Exiting program.");
            scanner.close();
            return;
        }

        if (tree == null) {
            System.out.println("Error: Training tree could not be created. Please check your training data.");
            return;
        }

        KNNClassifier<String> knnClassifier = new KNNClassifier<>(tree, 3);

        System.out.println("_________");
        Trainer.printTree(tree);
        System.out.println("_________");

        // Menu options
        while (true) {
            System.out.println("\n--- Creature Identifier ---");
            System.out.println("1. Enter a new animal");
            System.out.println("2. Generate a random animal and show prediction");
            System.out.println("3. Show training data samples");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (option) {
                case 1:
                    handleNewAnimal(scanner, knnClassifier);
                    break;

                case 2:
                    handleRandomAnimal(knnClassifier);
                    break;

                case 3:
                    System.out.println("Showing 5 training data samples from the tree:");
                    showTrainingSamples(tree, 5);
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

    private static void handleNewAnimal(Scanner scanner, KNNClassifier<String> knnClassifier) {
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

        // Predict species
        String predictedSpecies = knnClassifier.classify(userCreature);

        // Update node with predicted species
        userCreature = new Node<>(predictedSpecies, properties);

        // Validate consistency with predicted species
        if (!Trainer.isConsistent(userCreature)) {
            System.out.println("Error: The entered animal is inconsistent with the predicted species rules. Please check the values.");
        } else {
            System.out.println("Predicted species: " + predictedSpecies);
        }
    }

    private static void handleRandomAnimal(KNNClassifier<String> knnClassifier) {
        Node<String> randomCreature = DataGenerator.generateRandomCreature();
        System.out.println("Randomly generated animal:");
        randomCreature.getProperties().forEach((key, value) -> System.out.println(key + ": " + value));

        if (!Trainer.isConsistent(randomCreature)) {
            System.out.println("Error: Generated animal is inconsistent. Skipping classification.");
            return;
        }

        String randomPrediction = knnClassifier.classify(randomCreature);
        System.out.println("Predicted species: " + (randomPrediction.equals("Unknown") ? "Could not classify. Check training data." : randomPrediction));
    }

    private static void showTrainingSamples(BinaryTree<String> tree, int sampleCount) {
        showSamplesRecursively(tree, sampleCount, 0);
    }

    private static int showSamplesRecursively(BinaryTree<String> tree, int sampleCount, int count) {
        if (tree == null || count >= sampleCount) {
            return count;
        }

        System.out.println("Sample " + (count + 1) + ":");
        tree.getNode().getProperties().forEach((key, value) -> System.out.println("  " + key + ": " + value));
        System.out.println("  Species: " + tree.getNode().getSpecies());
        System.out.println();

        count++;
        count = showSamplesRecursively(tree.getLeft(), sampleCount, count);
        count = showSamplesRecursively(tree.getRight(), sampleCount, count);

        return count;
    }
}
