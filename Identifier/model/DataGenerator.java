import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DataGenerator {
    private static final String[] species = {"Mammal", "Bird", "Reptile", "Amphibian", "Fish", "Invertebrate"};
    private static final Random random = new Random();

    public static Node<String> generateRandomCreature() {
        Map<String, String> properties = new HashMap<>();
        String selectedSpecies = species[random.nextInt(species.length)];

        // Define logical characteristics based on species
        switch (selectedSpecies) {
            case "Mammal":
                properties.put("Size", getRandomValue(new String[]{"Small", "Medium", "Large"}));
                properties.put("Skin Type", "Fur");  // Only mammals have fur
                properties.put("Habitat", getRandomValue(new String[]{"Land", "Water"}));
                properties.put("Diet", getRandomValue(new String[]{"Herbivore", "Carnivore", "Omnivore"}));
                properties.put("Behavior", getRandomValue(new String[]{"Nocturnal", "Diurnal"}));
                break;

            case "Bird":
                properties.put("Size", getRandomValue(new String[]{"Small", "Medium", "Large"}));
                properties.put("Skin Type", "Feathers");  // Only birds have feathers
                properties.put("Habitat", "Air");
                properties.put("Diet", getRandomValue(new String[]{"Herbivore", "Carnivore"}));
                properties.put("Behavior", "Diurnal");
                break;

            case "Reptile":
                properties.put("Size", getRandomValue(new String[]{"Small", "Medium", "Large"}));
                properties.put("Skin Type", "Scales");  // Only reptiles have scales
                properties.put("Habitat", getRandomValue(new String[]{"Land", "Water"}));
                properties.put("Diet", getRandomValue(new String[]{"Carnivore", "Omnivore"}));
                properties.put("Behavior", "Nocturnal");
                break;

            case "Amphibian":
                properties.put("Size", getRandomValue(new String[]{"Small", "Medium"}));
                properties.put("Skin Type", "Moist Skin");  // Amphibians have moist skin
                properties.put("Habitat", "Water");
                properties.put("Diet", "Carnivore");
                properties.put("Behavior", "Nocturnal");
                break;

            case "Fish":
                properties.put("Size", getRandomValue(new String[]{"Small", "Medium", "Large"}));
                properties.put("Skin Type", "Scales");  // Fish also have scales
                properties.put("Habitat", "Water");
                properties.put("Diet", getRandomValue(new String[]{"Herbivore", "Carnivore", "Omnivore"}));
                properties.put("Behavior", "Diurnal");
                break;

            case "Invertebrate":
                properties.put("Size", getRandomValue(new String[]{"Tiny", "Small", "Medium"}));
                properties.put("Skin Type", getRandomValue(new String[]{"Exoskeleton", "Soft Body"}));
                properties.put("Habitat", getRandomValue(new String[]{"Land", "Water"}));
                properties.put("Diet", getRandomValue(new String[]{"Herbivore", "Carnivore", "Omnivore"}));
                properties.put("Behavior", "Nocturnal");
                break;
        }

        return new Node<>(selectedSpecies, properties);
    }

    private static String getRandomValue(String[] options) {
        return options[random.nextInt(options.length)];
    }
}
