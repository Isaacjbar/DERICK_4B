package jbar.creature_identifier.service;

import jbar.creature_identifier.model.Animal;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KnnClassifier {

    public int classify(Animal input, List<Animal> trainingSet, int k) {
        // Calcular distancias entre el input y cada animal en el conjunto de entrenamiento
        List<AnimalDistance> distances = trainingSet.stream()
                .map(animal -> new AnimalDistance(animal, calculateDistance(input, animal)))
                .sorted(Comparator.comparingDouble(AnimalDistance::getDistance))
                .collect(Collectors.toList());

        // Tomar los k vecinos más cercanos
        List<Integer> nearestSpecies = distances.stream()
                .limit(k)
                .map(animalDistance -> animalDistance.getAnimal().getSpecie())
                .collect(Collectors.toList());

        // Retornar la especie más común entre los vecinos
        return nearestSpecies.stream()
                .collect(Collectors.groupingBy(specie -> specie, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(-1); // Retorna -1 si no hay consenso
    }

    public List<AnimalDistance> getNearestNeighbors(Animal input, List<Animal> trainingSet, int k) {
        // Calcular distancias entre el input y cada animal en el conjunto de entrenamiento
        return trainingSet.stream()
                .map(animal -> new AnimalDistance(animal, calculateDistance(input, animal)))
                .sorted(Comparator.comparingDouble(AnimalDistance::getDistance))
                .limit(k) // Obtener los k vecinos más cercanos
                .collect(Collectors.toList());
    }

    private double calculateDistance(Animal a, Animal b) {
        // Calcular una métrica de distancia entre los dos animales
        double sizeDifference = Math.abs(a.getSize() - b.getSize());

        // Sumar las diferencias binarias
        int furDifference = a.getHasFur() == b.getHasFur() ? 0 : 1;
        int aquaticDifference = a.getIsAquatic() == b.getIsAquatic() ? 0 : 1;
        int carnivoreDifference = a.getIsCarnivore() == b.getIsCarnivore() ? 0 : 1;
        int nocturnalDifference = a.getIsNocturnal() == b.getIsNocturnal() ? 0 : 1;
        int wingsDifference = a.getHasWings() == b.getHasWings() ? 0 : 1;
        int domesticatedDifference = a.getIsDomesticated() == b.getIsDomesticated() ? 0 : 1;
        int endangeredDifference = a.getIsEndangered() == b.getIsEndangered() ? 0 : 1;
        int clawsDifference = a.getHasClaws() == b.getHasClaws() ? 0 : 1;
        int flyDifference = a.getCanFly() == b.getCanFly() ? 0 : 1;

        // La distancia es la suma de todas las diferencias
        return sizeDifference + furDifference + aquaticDifference + carnivoreDifference +
                nocturnalDifference + wingsDifference + domesticatedDifference + endangeredDifference +
                clawsDifference + flyDifference;
    }

    public static class AnimalDistance {
        private Animal animal;
        private double distance;

        public AnimalDistance(Animal animal, double distance) {
            this.animal = animal;
            this.distance = distance;
        }

        public Animal getAnimal() {
            return animal;
        }

        public double getDistance() {
            return distance;
        }
    }
}
