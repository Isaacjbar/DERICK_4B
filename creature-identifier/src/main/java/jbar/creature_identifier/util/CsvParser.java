package jbar.creature_identifier.util;

import jbar.creature_identifier.model.Animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public static List<Animal> parseCsv(BufferedReader reader) throws IOException {
        List<Animal> animals = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            // Dividir los valores del CSV por comas
            String[] values = line.split(",");

            // Crear un nuevo objeto Animal
            Animal animal = new Animal();

            // Convertir cada valor del CSV a las propiedades correspondientes del objeto Animal
            animal.setSpecie(Integer.parseInt(values[0]));  // Especie (int)
            animal.setSize(Double.parseDouble(values[1]));  // Tamaño (double)

            // Las propiedades binarias (0 o 1)
            animal.setHasFur(Integer.parseInt(values[2]));          // Tiene pelo (0 o 1)
            animal.setIsAquatic(Integer.parseInt(values[3]));       // Acuático (0 o 1)
            animal.setIsCarnivore(Integer.parseInt(values[4]));     // Carnívoro (0 o 1)
            animal.setIsNocturnal(Integer.parseInt(values[5]));     // Nocturno (0 o 1)
            animal.setHasWings(Integer.parseInt(values[6]));        // Tiene alas (0 o 1)
            animal.setIsDomesticated(Integer.parseInt(values[7]));  // Domesticado (0 o 1)
            animal.setIsEndangered(Integer.parseInt(values[8]));    // En peligro (0 o 1)
            animal.setHasClaws(Integer.parseInt(values[9]));        // Tiene garras (0 o 1)
            animal.setCanFly(Integer.parseInt(values[10]));         // Puede volar (0 o 1)

            // Agregar el animal a la lista
            animals.add(animal);
        }

        return animals;
    }
}
