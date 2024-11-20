package jbar.creature_identifier.util;

import jbar.creature_identifier.model.Animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public static List<Animal> parseCsv(BufferedReader reader) throws IOException {
        List<Animal> animals = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            Animal animal = new Animal();
            animal.setSpecie(values[0]);
            animal.setSize(values[1]);
            animal.setSkinType(values[2]);
            animal.setHabitat(values[3]);
            animal.setDiet(values[4]);
            animal.setBehavior(values[5]);
            animals.add(animal);
        }

        return animals;
    }
}
