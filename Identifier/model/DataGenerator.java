import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DataGenerator {
    private static final String[] species = {"Mammal", "Bird", "Reptile", "Amphibian", "Fish", "Invertebrate"};
    private static final String[] sizes = {"Small", "Medium", "Large"};
    private static final String[] skinTypes = {"Fur", "Scales", "Feathers"};
    private static final String[] habitats = {"Land", "Water", "Air"};
    private static final String[] diets = {"Herbivore", "Carnivore", "Omnivore"};
    private static final Random random = new Random();

    public static Node<String> generateRandomCreature() {
        Map<String, String> properties = new HashMap<>();
        properties.put("Size", sizes[random.nextInt(sizes.length)]);
        properties.put("Skin Type", skinTypes[random.nextInt(skinTypes.length)]);
        properties.put("Habitat", habitats[random.nextInt(habitats.length)]);
        properties.put("Diet", diets[random.nextInt(diets.length)]);
        String species = DataGenerator.species[random.nextInt(DataGenerator.species.length)];
        return new Node<>(species, properties);
    }
}
