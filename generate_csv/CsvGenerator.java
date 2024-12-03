import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CsvGenerator {

    private static final Random random = new Random();

    // Especies
    private static final String[] SPECIES = {
        "Mammal",     // 1
        "Bird",       // 2
        "Reptile",    // 3
        "Fish",       // 4
        "Amphibian",  // 5
        "Insect"      // 6
    };

    // Método para generar datos aleatorios para entrenamiento
    public static List<Animal> generateTrainingData(int numberOfAnimals) {
        List<Animal> animals = new ArrayList<>();

        for (int i = 0; i < numberOfAnimals; i++) {
            // Seleccionar una especie aleatoria entre 1 y 6
            int specieId = random.nextInt(6) + 1;
            Animal animal = new Animal();
            animal.setSpecie(specieId);
            
            // Asignar el tamaño aleatorio (double) entre 0.1 y 3.0, con dos decimales
            double size = 0.1 + (random.nextDouble() * 2.9);  // Tamaño entre 0.1 y 3.0 metros
            animal.setSize(Math.round(size * 100.0) / 100.0);  // Redondear a dos decimales

            // Asignar características en función de la especie
            switch (specieId) {
                case 1: // Mammal
                    animal.setHasFur(1);            // Tiene pelo
                    animal.setIsAquatic(0);        // No acuático
                    animal.setIsCarnivore(random.nextInt(2)); // Carnívoro aleatorio
                    animal.setIsNocturnal(random.nextInt(2)); // Nocturno aleatorio
                    animal.setHasWings(0);         // No tiene alas
                    animal.setIsDomesticated(random.nextInt(2)); // Domesticado aleatorio
                    animal.setIsEndangered(random.nextInt(2));  // En peligro aleatorio
                    animal.setHasClaws(1);         // Tiene garras
                    animal.setCanFly(0);           // No puede volar
                    break;
                case 2: // Bird
                    animal.setHasFur(0);            // No tiene pelo
                    animal.setIsAquatic(0);        // No acuático
                    animal.setIsCarnivore(random.nextInt(2)); // Carnívoro aleatorio
                    animal.setIsNocturnal(random.nextInt(2)); // Nocturno aleatorio
                    animal.setHasWings(1);         // Tiene alas
                    animal.setIsDomesticated(random.nextInt(2)); // Domesticado aleatorio
                    animal.setIsEndangered(random.nextInt(2));  // En peligro aleatorio
                    animal.setHasClaws(0);         // No tiene garras
                    animal.setCanFly(1);           // Puede volar
                    break;
                case 3: // Reptile
                    animal.setHasFur(0);            // No tiene pelo
                    animal.setIsAquatic(random.nextInt(2));    // Puede ser acuático
                    animal.setIsCarnivore(random.nextInt(2)); // Carnívoro aleatorio
                    animal.setIsNocturnal(random.nextInt(2)); // Nocturno aleatorio
                    animal.setHasWings(0);         // No tiene alas
                    animal.setIsDomesticated(random.nextInt(2)); // Domesticado aleatorio
                    animal.setIsEndangered(random.nextInt(2));  // En peligro aleatorio
                    animal.setHasClaws(1);         // Tiene garras
                    animal.setCanFly(0);           // No puede volar
                    break;
                case 4: // Fish
                    animal.setHasFur(0);            // No tiene pelo
                    animal.setIsAquatic(1);        // Es acuático
                    animal.setIsCarnivore(random.nextInt(2)); // Carnívoro aleatorio
                    animal.setIsNocturnal(random.nextInt(2)); // Nocturno aleatorio
                    animal.setHasWings(0);         // No tiene alas
                    animal.setIsDomesticated(0);   // No domesticado
                    animal.setIsEndangered(random.nextInt(2));  // En peligro aleatorio
                    animal.setHasClaws(0);         // No tiene garras
                    animal.setCanFly(0);           // No puede volar
                    break;
                case 5: // Amphibian
                    animal.setHasFur(0);            // No tiene pelo
                    animal.setIsAquatic(random.nextInt(2));    // Puede ser acuático
                    animal.setIsCarnivore(random.nextInt(2)); // Carnívoro aleatorio
                    animal.setIsNocturnal(random.nextInt(2)); // Nocturno aleatorio
                    animal.setHasWings(0);         // No tiene alas
                    animal.setIsDomesticated(random.nextInt(2)); // Domesticado aleatorio
                    animal.setIsEndangered(random.nextInt(2));  // En peligro aleatorio
                    animal.setHasClaws(0);         // No tiene garras
                    animal.setCanFly(0);           // No puede volar
                    break;
                case 6: // Insect
                    animal.setHasFur(0);            // No tiene pelo
                    animal.setIsAquatic(0);        // No acuático
                    animal.setIsCarnivore(random.nextInt(2)); // Carnívoro aleatorio
                    animal.setIsNocturnal(random.nextInt(2)); // Nocturno aleatorio
                    animal.setHasWings(1);         // Tiene alas
                    animal.setIsDomesticated(random.nextInt(2)); // Domesticado aleatorio
                    animal.setIsEndangered(random.nextInt(2));  // En peligro aleatorio
                    animal.setHasClaws(0);         // No tiene garras
                    animal.setCanFly(1);           // Puede volar
                    break;
                default:
                    break;
            }

            animals.add(animal);
        }

        return animals;
    }

    // Método para escribir los datos en un archivo CSV
    public static void writeCsv(List<Animal> animals, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        // Escribir la cabecera del CSV
        writer.write("Specie,Size,HasFur,IsAquatic,IsCarnivore,IsNocturnal,HasWings,IsDomesticated,IsEndangered,HasClaws,CanFly\n");

        // Escribir los datos de los animales
        for (Animal animal : animals) {
            writer.write(animal.getSpecie() + "," +
                         animal.getSize() + "," +
                         animal.getHasFur() + "," +
                         animal.getIsAquatic() + "," +
                         animal.getIsCarnivore() + "," +
                         animal.getIsNocturnal() + "," +
                         animal.getHasWings() + "," +
                         animal.getIsDomesticated() + "," +
                         animal.getIsEndangered() + "," +
                         animal.getHasClaws() + "," +
                         animal.getCanFly() + "\n");
        }

        writer.close();
    }

    public static void main(String[] args) {
        try {
            // Generar 100 animales aleatorios
            List<Animal> animals = generateTrainingData(100);

            // Escribir los datos generados en un archivo CSV
            writeCsv(animals, "generated_animals.csv");

            System.out.println("CSV generado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
