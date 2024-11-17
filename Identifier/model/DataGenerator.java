import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DataGenerator {
    private static final String[] species = {"Mammal", "Bird", "Reptile", "Amphibian", "Fish", "Invertebrate"};
    private static final Random random = new Random();

    public static Node<String> generateRandomCreature() {
        String selectedSpecies = species[random.nextInt(species.length)];
        Map<String, String> properties = new HashMap<>();

        // Define logical characteristics based on species
        switch (selectedSpecies) {
            case "Mammal":
                properties.put("Size", getRandomValue(new String[]{"Small", "Medium", "Large"}));
                properties.put("Skin Type", "Fur");
                properties.put("Habitat", getRandomValue(new String[]{"Land", "Water"}));
                properties.put("Diet", getRandomValue(new String[]{"Herbivore", "Carnivore", "Omnivore"}));
                properties.put("Behavior", getRandomValue(new String[]{"Nocturnal", "Diurnal"}));
                break;

            case "Bird":
                properties.put("Size", getRandomValue(new String[]{"Small", "Medium", "Large"}));
                properties.put("Skin Type", "Feathers");
                properties.put("Habitat", "Air");
                properties.put("Diet", getRandomValue(new String[]{"Herbivore", "Carnivore", "Omnivore"}));
                properties.put("Behavior", getRandomValue(new String[]{"Nocturnal", "Diurnal"}));
                break;

            case "Reptile":
                properties.put("Size", getRandomValue(new String[]{"Small", "Medium", "Large"}));
                properties.put("Skin Type", "Scales");
                properties.put("Habitat", getRandomValue(new String[]{"Land", "Water"}));
                properties.put("Diet", getRandomValue(new String[]{"Herbivore", "Carnivore", "Omnivore"}));
                properties.put("Behavior", getRandomValue(new String[]{"Nocturnal", "Diurnal"}));
                break;

            case "Amphibian":
                properties.put("Size", getRandomValue(new String[]{"Small", "Medium"}));
                properties.put("Skin Type", "Moist Skin");
                properties.put("Habitat", "Water");
                properties.put("Diet", getRandomValue(new String[]{"Carnivore", "Omnivore"}));
                properties.put("Behavior", getRandomValue(new String[]{"Nocturnal", "Diurnal"}));
                break;

            case "Fish":
                properties.put("Size", getRandomValue(new String[]{"Small", "Medium", "Large"}));
                properties.put("Skin Type", "Scales");
                properties.put("Habitat", "Water");
                properties.put("Diet", getRandomValue(new String[]{"Herbivore", "Carnivore", "Omnivore"}));
                properties.put("Behavior", getRandomValue(new String[]{"Nocturnal", "Diurnal"}));
                break;

            case "Invertebrate":
                properties.put("Size", getRandomValue(new String[]{"Tiny", "Small", "Medium"}));
                properties.put("Skin Type", getRandomValue(new String[]{"Exoskeleton", "Soft Body"}));
                properties.put("Habitat", getRandomValue(new String[]{"Land", "Water"}));
                properties.put("Diet", getRandomValue(new String[]{"Herbivore", "Carnivore", "Omnivore"}));
                properties.put("Behavior", getRandomValue(new String[]{"Nocturnal", "Diurnal"}));
                break;
        }

        return new Node<>(selectedSpecies, properties);
    }

    private static String getRandomValue(String[] options) {
        return options[random.nextInt(options.length)];
    }
}
