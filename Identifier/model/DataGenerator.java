import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DataGenerator {
    private static final String[] species = {"Mammal", "Bird", "Reptile", "Amphibian", "Fish", "Invertebrate"};
    private static final String[] animals = {
        "Cow", "Mouse", "Tiger", "Elephant", "Horse", "Dog", "Cat",
        "Eagle", "Parrot", "Penguin", "Hawk", "Sparrow",
        "Snake", "Lizard", "Crocodile", "Turtle",
        "Frog", "Toad", "Salamander",
        "Salmon", "Shark", "Dolphin", "Whale",
        "Spider", "Ant", "Butterfly", "Bee", "Scorpion"
    };
    private static final Random random = new Random();

    public static Node<String> generateRandomCreature() {
        Map<String, String> properties = new HashMap<>();
        String selectedSpecies = species[random.nextInt(species.length)];
        String selectedAnimal = animals[random.nextInt(animals.length)];

        // Define logical characteristics based on species
        switch (selectedSpecies) {
            case "Mammal":
                properties.put("Size", getRandomValue(new String[]{"Small", "Medium", "Large"}));
                properties.put("Skin Type", "Fur");
                properties.put("Habitat", getRandomValue(new String[]{"Land", "Forest"}));
                properties.put("Diet", getRandomValue(new String[]{"Herbivore", "Carnivore", "Omnivore"}));
                properties.put("Blood Type", "Warm-blooded");
                properties.put("Reproduction", "Viviparous");
                properties.put("Lifespan", getRandomValue(new String[]{"Medium", "Long"}));
                properties.put("Defense", getRandomValue(new String[]{"Claws", "Teeth"}));
                properties.put("Sound", getRandomValue(new String[]{"Roar", "Grunt"}));
                properties.put("Color Pattern", getRandomValue(new String[]{"Uniform", "Spotted", "Striped"}));
                break;

            case "Bird":
                properties.put("Size", getRandomValue(new String[]{"Small", "Medium", "Large"}));
                properties.put("Skin Type", "Feathers");
                properties.put("Habitat", "Air");
                properties.put("Diet", getRandomValue(new String[]{"Herbivore", "Carnivore"}));
                properties.put("Blood Type", "Warm-blooded");
                properties.put("Reproduction", "Oviparous");
                properties.put("Lifespan", getRandomValue(new String[]{"Medium", "Long"}));
                properties.put("Defense", "Beak");
                properties.put("Sound", "Chirp");
                properties.put("Color Pattern", getRandomValue(new String[]{"Uniform", "Spotted", "Striped"}));
                break;

            case "Reptile":
                properties.put("Size", getRandomValue(new String[]{"Small", "Medium", "Large"}));
                properties.put("Skin Type", "Scales");
                properties.put("Habitat", getRandomValue(new String[]{"Land", "Water"}));
                properties.put("Diet", getRandomValue(new String[]{"Carnivore", "Omnivore"}));
                properties.put("Blood Type", "Cold-blooded");
                properties.put("Reproduction", "Oviparous");
                properties.put("Lifespan", getRandomValue(new String[]{"Medium", "Long"}));
                properties.put("Defense", "Venom");
                properties.put("Sound", "Hiss");
                properties.put("Color Pattern", "Uniform");
                break;

            case "Amphibian":
                properties.put("Size", getRandomValue(new String[]{"Small", "Medium"}));
                properties.put("Skin Type", "Moist Skin");
                properties.put("Habitat", "Water");
                properties.put("Diet", "Carnivore");
                properties.put("Blood Type", "Cold-blooded");
                properties.put("Reproduction", "Oviparous");
                properties.put("Lifespan", "Short");
                properties.put("Defense", "Camouflage");
                properties.put("Sound", "Croak");
                properties.put("Color Pattern", "Uniform");
                break;

            case "Fish":
                properties.put("Size", getRandomValue(new String[]{"Small", "Medium", "Large"}));
                properties.put("Skin Type", "Scales");
                properties.put("Habitat", "Water");
                properties.put("Diet", getRandomValue(new String[]{"Herbivore", "Carnivore", "Omnivore"}));
                properties.put("Blood Type", "Cold-blooded");
                properties.put("Reproduction", "Oviparous");
                properties.put("Lifespan", getRandomValue(new String[]{"Short", "Medium"}));
                properties.put("Defense", "Swim Fast");
                properties.put("Sound", "Silent");
                properties.put("Color Pattern", getRandomValue(new String[]{"Uniform", "Spotted"}));
                break;

            case "Invertebrate":
                properties.put("Size", getRandomValue(new String[]{"Tiny", "Small", "Medium"}));
                properties.put("Skin Type", getRandomValue(new String[]{"Exoskeleton", "Soft Body"}));
                properties.put("Habitat", getRandomValue(new String[]{"Land", "Water"}));
                properties.put("Diet", getRandomValue(new String[]{"Herbivore", "Carnivore", "Omnivore"}));
                properties.put("Blood Type", "Cold-blooded");
                properties.put("Reproduction", "Oviparous");
                properties.put("Lifespan", getRandomValue(new String[]{"Short", "Medium"}));
                properties.put("Defense", getRandomValue(new String[]{"Camouflage", "Venom"}));
                properties.put("Sound", "Buzz");
                properties.put("Color Pattern", "Uniform");
                break;
        }

        // Additional characteristics based on specific animals
        switch (selectedAnimal) {
            case "Cow":
                properties.put("Sound", "Moo");
                properties.put("Diet", "Herbivore");
                properties.put("Size", "Large");
                properties.put("Color Pattern", "Spotted");
                properties.put("Habitat", "Land");
                properties.put("Reproduction", "Viviparous");
                break;

            case "Mouse":
                properties.put("Sound", "Squeak");
                properties.put("Diet", "Omnivore");
                properties.put("Size", "Small");
                properties.put("Color Pattern", "Uniform");
                properties.put("Habitat", "Land");
                properties.put("Reproduction", "Viviparous");
                break;

            case "Tiger":
                properties.put("Sound", "Roar");
                properties.put("Diet", "Carnivore");
                properties.put("Size", "Large");
                properties.put("Color Pattern", "Striped");
                properties.put("Habitat", "Forest");
                properties.put("Reproduction", "Viviparous");
                break;

            case "Elephant":
                properties.put("Sound", "Trumpet");
                properties.put("Diet", "Herbivore");
                properties.put("Size", "Very Large");
                properties.put("Color Pattern", "Uniform");
                properties.put("Habitat", "Savannah");
                properties.put("Reproduction", "Viviparous");
                break;

            case "Horse":
                properties.put("Sound", "Neigh");
                properties.put("Diet", "Herbivore");
                properties.put("Size", "Large");
                properties.put("Color Pattern", "Uniform");
                properties.put("Habitat", "Grassland");
                properties.put("Reproduction", "Viviparous");
                break;

            case "Dog":
                properties.put("Sound", "Bark");
                properties.put("Diet", "Omnivore");
                properties.put("Size", "Varies");
                properties.put("Color Pattern", "Varies");
                properties.put("Habitat", "Domestic");
                properties.put("Reproduction", "Viviparous");
                break;

            case "Cat":
                properties.put("Sound", "Meow");
                properties.put("Diet", "Carnivore");
                properties.put("Size", "Small");
                properties.put("Color Pattern", "Varies");
                properties.put("Habitat", "Domestic");
                properties.put("Reproduction", "Viviparous");
                break;

            case "Eagle":
                properties.put("Sound", "Screech");
                properties.put("Diet", "Carnivore");
                properties.put("Size", "Medium");
                properties.put("Habitat", "Mountains");
                properties.put("Color Pattern", "Uniform");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Parrot":
                properties.put("Sound", "Squawk");
                properties.put("Diet", "Omnivore");
                properties.put("Size", "Small");
                properties.put("Habitat", "Tropical");
                properties.put("Color Pattern", "Varies");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Penguin":
                properties.put("Sound", "Honk");
                properties.put("Diet", "Carnivore");
                properties.put("Size", "Medium");
                properties.put("Habitat", "Cold Coastal");
                properties.put("Color Pattern", "Black and White");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Hawk":
                properties.put("Sound", "Screech");
                properties.put("Diet", "Carnivore");
                properties.put("Size", "Medium");
                properties.put("Habitat", "Forest");
                properties.put("Color Pattern", "Brown");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Sparrow":
                properties.put("Sound", "Chirp");
                properties.put("Diet", "Omnivore");
                properties.put("Size", "Small");
                properties.put("Habitat", "Urban");
                properties.put("Color Pattern", "Brown");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Snake":
                properties.put("Sound", "Hiss");
                properties.put("Diet", "Carnivore");
                properties.put("Size", "Varies");
                properties.put("Habitat", "Land");
                properties.put("Color Pattern", "Varies");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Lizard":
                properties.put("Sound", "Silent");
                properties.put("Diet", "Omnivore");
                properties.put("Size", "Small");
                properties.put("Habitat", "Desert");
                properties.put("Color Pattern", "Varies");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Crocodile":
                properties.put("Sound", "Growl");
                properties.put("Diet", "Carnivore");
                properties.put("Size", "Large");
                properties.put("Habitat", "Water");
                properties.put("Color Pattern", "Uniform");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Turtle":
                properties.put("Sound", "Silent");
                properties.put("Diet", "Herbivore");
                properties.put("Size", "Medium");
                properties.put("Habitat", "Water");
                properties.put("Color Pattern", "Uniform");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Frog":
                properties.put("Sound", "Croak");
                properties.put("Diet", "Carnivore");
                properties.put("Size", "Small");
                properties.put("Habitat", "Water");
                properties.put("Color Pattern", "Uniform");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Toad":
                properties.put("Sound", "Croak");
                properties.put("Diet", "Carnivore");
                properties.put("Size", "Medium");
                properties.put("Habitat", "Land");
                properties.put("Color Pattern", "Warty");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Salamander":
                properties.put("Sound", "Silent");
                properties.put("Diet", "Carnivore");
                properties.put("Size", "Small");
                properties.put("Habitat", "Wetland");
                properties.put("Color Pattern", "Spotted");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Salmon":
                properties.put("Sound", "Silent");
                properties.put("Diet", "Omnivore");
                properties.put("Size", "Medium");
                properties.put("Habitat", "Freshwater");
                properties.put("Color Pattern", "Uniform");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Shark":
                properties.put("Sound", "Silent");
                properties.put("Diet", "Carnivore");
                properties.put("Size", "Large");
                properties.put("Habitat", "Ocean");
                properties.put("Color Pattern", "Gray");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Dolphin":
                properties.put("Sound", "Click");
                properties.put("Diet", "Carnivore");
                properties.put("Size", "Medium");
                properties.put("Habitat", "Ocean");
                properties.put("Color Pattern", "Gray");
                properties.put("Reproduction", "Viviparous");
                break;

            case "Whale":
                properties.put("Sound", "Song");
                properties.put("Diet", "Carnivore");
                properties.put("Size", "Very Large");
                properties.put("Habitat", "Ocean");
                properties.put("Color Pattern", "Uniform");
                properties.put("Reproduction", "Viviparous");
                break;

            case "Spider":
                properties.put("Sound", "Silent");
                properties.put("Diet", "Carnivore");
                properties.put("Size", "Small");
                properties.put("Habitat", "Land");
                properties.put("Color Pattern", "Varies");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Ant":
                properties.put("Sound", "Silent");
                properties.put("Diet", "Omnivore");
                properties.put("Size", "Tiny");
                properties.put("Habitat", "Land");
                properties.put("Color Pattern", "Uniform");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Butterfly":
                properties.put("Sound", "Silent");
                properties.put("Diet", "Herbivore");
                properties.put("Size", "Small");
                properties.put("Habitat", "Land");
                properties.put("Color Pattern", "Varies");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Bee":
                properties.put("Sound", "Buzz");
                properties.put("Diet", "Herbivore");
                properties.put("Size", "Tiny");
                properties.put("Habitat", "Land");
                properties.put("Color Pattern", "Yellow and Black");
                properties.put("Reproduction", "Oviparous");
                break;

            case "Scorpion":
                properties.put("Sound", "Silent");
                properties.put("Diet", "Carnivore");
                properties.put("Size", "Small");
                properties.put("Habitat", "Desert");
                properties.put("Color Pattern", "Uniform");
                properties.put("Reproduction", "Oviparous");
                break;
        }

        return new Node<>(selectedAnimal, properties);
    }

    private static String getRandomValue(String[] options) {
        return options[random.nextInt(options.length)];
    }
}
