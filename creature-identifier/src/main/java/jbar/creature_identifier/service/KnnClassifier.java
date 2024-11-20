package jbar.creature_identifier.service;

import jbar.creature_identifier.model.Animal;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KnnClassifier {

    public String classify(Animal input, List<Animal> trainingSet, int k) {
        // Calcular distancias entre el input y cada animal en el conjunto de entrenamiento
        List<AnimalDistance> distances = trainingSet.stream()
                .map(animal -> new AnimalDistance(animal, calculateDistance(input, animal)))
                .sorted(Comparator.comparingDouble(AnimalDistance::getDistance))
                .collect(Collectors.toList());

        // Tomar los k vecinos más cercanos
        List<String> nearestSpecies = distances.subList(0, k).stream()
                .map(animalDistance -> animalDistance.getAnimal().getSpecie())
                .collect(Collectors.toList());

        // Retornar la especie más común entre los vecinos
        return nearestSpecies.stream()
                .collect(Collectors.groupingBy(specie -> specie, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("Unknown");
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
        // Implementar una métrica de distancia (e.g., distancia euclidiana)
        int sizeDifference = Math.abs(a.getSize().compareTo(b.getSize()));
        int skinDifference = a.getSkinType().equals(b.getSkinType()) ? 0 : 1;
        int habitatDifference = a.getHabitat().equals(b.getHabitat()) ? 0 : 1;
        int dietDifference = a.getDiet().equals(b.getDiet()) ? 0 : 1;
        int behaviorDifference = a.getBehavior().equals(b.getBehavior()) ? 0 : 1;

        return sizeDifference + skinDifference + habitatDifference + dietDifference + behaviorDifference;
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
