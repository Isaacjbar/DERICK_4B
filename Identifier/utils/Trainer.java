import model.Node;
import structures.BinaryTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.DataGenerator;

public class Trainer {

    public static void generateCSVSample(String filePath, int numberOfDataPoints) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Species,Size,Skin Type,Habitat,Diet,Behavior\n");

            for (int i = 0; i < numberOfDataPoints; i++) {
                Node<String> creature = DataGenerator.generateRandomCreature();
                writer.append(creature.getSpecies()).append(",");

                Map<String, String> properties = creature.getProperties();
                writer.append(properties.get("Size")).append(",");
                writer.append(properties.get("Skin Type")).append(",");
                writer.append(properties.get("Habitat")).append(",");
                writer.append(properties.get("Diet")).append(",");
                writer.append(properties.get("Behavior")).append("\n");
            }

            System.out.println("Sample CSV file generated successfully at: " + filePath);
        } catch (IOException e) {
            System.out.println("Error generating CSV file: " + e.getMessage());
        }
    }

    public static BinaryTree<String> trainTreeFromCSV(String filePath) {
        BinaryTree<String> tree = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length < 6) {
                    System.out.println("Inconsistent data in CSV, skipping: " + line);
                    continue;
                }

                String species = attributes[0];
                Map<String, String> properties = new HashMap<>();
                properties.put("Size", attributes[1]);
                properties.put("Skin Type", attributes[2]);
                properties.put("Habitat", attributes[3]);
                properties.put("Diet", attributes[4]);
                properties.put("Behavior", attributes[5]);

                Node<String> creature = new Node<>(species, properties);

                if (isConsistent(creature)) {
                    if (tree == null) {
                        tree = new BinaryTree<>(creature);
                    } else {
                        tree.insert(creature, "Size");
                    }
                } else {
                    System.out.println("Inconsistent data in CSV, skipping: " + line);
                }
            }

            System.out.println("CSV data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        return tree;
    }

    public static BinaryTree<String> trainTree(int numberOfDataPoints) {
        BinaryTree<String> tree = null;

        for (int i = 0; i < numberOfDataPoints; i++) {
            Node<String> creature = DataGenerator.generateRandomCreature();

            if (isConsistent(creature)) {
                if (tree == null) {
                    tree = new BinaryTree<>(creature);
                } else {
                    tree.insert(creature, "Size");
                }
            } else {
                System.out.println("Inconsistent data point detected, skipping...");
            }
        }
        return tree;
    }

    public static boolean isConsistent(Node<String> node) {
        String species = node.getSpecies();
        String skinType = node.getProperty("Skin Type");
        String habitat = node.getProperty("Habitat");
        String size = node.getProperty("Size");
        String diet = node.getProperty("Diet");
        String behavior = node.getProperty("Behavior");

        System.out.println("Validating: Species=" + species + ", Skin Type=" + skinType + ", Habitat=" + habitat +
        ", Size=" + size + ", Diet=" + diet + ", Behavior=" + behavior);

        // Validaciones detalladas para cada especie
        switch (species) {
            case "Mammal":
                return validateMammal(skinType, habitat, size, diet, behavior);

            case "Bird":
                return validateBird(skinType, habitat, size, diet, behavior);

            case "Reptile":
                return validateReptile(skinType, habitat, size, diet, behavior);

            case "Amphibian":
                return validateAmphibian(skinType, habitat, size, diet, behavior);

            case "Fish":
                return validateFish(skinType, habitat, size, diet, behavior);

            case "Invertebrate":
                return validateInvertebrate(skinType, habitat, size, diet, behavior);

            default:
                return false;
        }
    }

    private static boolean validateMammal(String skinType, String habitat, String size, String diet, String behavior) {
        return skinType.equals("Fur") &&
               (habitat.equals("Land") || habitat.equals("Water")) &&
               (size.equals("Small") || size.equals("Medium") || size.equals("Large")) &&
               (diet.equals("Herbivore") || diet.equals("Carnivore") || diet.equals("Omnivore")) &&
               (behavior.equals("Nocturnal") || behavior.equals("Diurnal"));
    }

    private static boolean validateBird(String skinType, String habitat, String size, String diet, String behavior) {
        return skinType.equals("Feathers") &&
               habitat.equals("Air") &&
               (size.equals("Small") || size.equals("Medium") || size.equals("Large")) &&
               (diet.equals("Herbivore") || diet.equals("Carnivore") || diet.equals("Omnivore")) &&
               (behavior.equals("Nocturnal") || behavior.equals("Diurnal"));
    }

    private static boolean validateReptile(String skinType, String habitat, String size, String diet, String behavior) {
        return skinType.equals("Scales") &&
               (habitat.equals("Land") || habitat.equals("Water")) &&
               (size.equals("Small") || size.equals("Medium") || size.equals("Large")) &&
               (diet.equals("Herbivore") || diet.equals("Carnivore") || diet.equals("Omnivore")) &&
               (behavior.equals("Nocturnal") || behavior.equals("Diurnal"));
    }

    private static boolean validateAmphibian(String skinType, String habitat, String size, String diet, String behavior) {
        return skinType.equals("Moist Skin") &&
               habitat.equals("Water") &&
               (size.equals("Small") || size.equals("Medium")) &&
               diet.equals("Carnivore") &&
               (behavior.equals("Nocturnal") || behavior.equals("Diurnal"));
    }

    private static boolean validateFish(String skinType, String habitat, String size, String diet, String behavior) {
        return skinType.equals("Scales") &&
               habitat.equals("Water") &&
               (size.equals("Small") || size.equals("Medium") || size.equals("Large")) &&
               (diet.equals("Herbivore") || diet.equals("Carnivore") || diet.equals("Omnivore")) &&
               (behavior.equals("Nocturnal") || behavior.equals("Diurnal"));
    }

    private static boolean validateInvertebrate(String skinType, String habitat, String size, String diet, String behavior) {
        return (skinType.equals("Exoskeleton") || skinType.equals("Soft Body")) &&
               (habitat.equals("Land") || habitat.equals("Water")) &&
               (size.equals("Tiny") || size.equals("Small") || size.equals("Medium")) &&
               (diet.equals("Herbivore") || diet.equals("Carnivore") || diet.equals("Omnivore")) &&
               (behavior.equals("Nocturnal") || behavior.equals("Diurnal"));
    }

    public static void printTree(BinaryTree<String> tree) {
        if (tree == null) return;
        Node<String> node = tree.getNode();
        System.out.println("Species: " + node.getSpecies() + ", Properties: " + node.getProperties());
        printTree(tree.getLeft());
        printTree(tree.getRight());
    }
}
