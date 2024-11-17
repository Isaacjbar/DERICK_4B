import model.Node;
import structures.BinaryTree;

import java.util.*;

public class KNNClassifier<T> {
    private final BinaryTree<T> tree;
    private final int k;
    private final Map<String, Double> weights;

    public KNNClassifier(BinaryTree<T> tree, int k) {
        this.tree = tree;
        this.k = k;

        // Initialize weights for each feature
        weights = Map.of(
                "Size", 0.5,
                "Skin Type", 8.0,
                "Habitat", 12.0,
                "Diet", 3.0,
                "Behavior", 1.0
        );
    }

    public String classify(Node<T> newCreature) {
        // Priority queue for closest neighbors
        PriorityQueue<NodeDistance<T>> closestNeighbors = new PriorityQueue<>((a, b) -> Double.compare(a.distance, b.distance));

        // Find the closest neighbors
        findNeighbors(tree, newCreature, closestNeighbors);

        // Show debug info: neighbors and their distances
        System.out.println("Neighbors used for classification:");
        closestNeighbors.forEach(neighbor -> System.out.println(
                "Species: " + neighbor.node.getSpecies() + ", Distance: " + neighbor.distance));

        // Determine the most compatible species
        return determineSpecies(newCreature, closestNeighbors);
    }

    private void findNeighbors(BinaryTree<T> currentTree, Node<T> targetNode, PriorityQueue<NodeDistance<T>> neighbors) {
        if (currentTree == null) return;

        // Calculate distance and add to priority queue
        double dist = distance(currentTree.getNode(), targetNode);
        neighbors.add(new NodeDistance<>(currentTree.getNode(), dist));

        // Maintain only k nearest neighbors
        if (neighbors.size() > k) {
            neighbors.poll(); // Remove the farthest neighbor
        }

        // Recursively search left and right subtrees
        findNeighbors(currentTree.getLeft(), targetNode, neighbors);
        findNeighbors(currentTree.getRight(), targetNode, neighbors);
    }

    private double distance(Node<T> node1, Node<T> node2) {
        double totalDistance = 0;

        for (String key : weights.keySet()) {
            T value1 = node1.getProperty(key);
            T value2 = node2.getProperty(key);
            double weight = weights.get(key);

            // Handle missing or null values
            if (value1 == null || value2 == null) {
                totalDistance += weight * 2; // High penalty for missing values
                continue;
            }

            // Handle categorical values (strings)
            if (value1 instanceof String && value2 instanceof String) {
                totalDistance += !value1.equals(value2) ? weight : 0;
            }
            // Handle numerical values
            else if (value1 instanceof Number && value2 instanceof Number) {
                double diff = ((Number) value1).doubleValue() - ((Number) value2).doubleValue();
                totalDistance += weight * (diff * diff);
            } else {
                // High penalty for incompatible types
                totalDistance += weight * 3;
            }
        }

        return Math.sqrt(totalDistance);
    }

    private String determineSpecies(Node<T> newCreature, PriorityQueue<NodeDistance<T>> neighbors) {
        Map<String, Double> speciesScore = new HashMap<>();
        Map<String, Integer> speciesCount = new HashMap<>();
    
        for (NodeDistance<T> neighbor : neighbors) {
            String species = neighbor.node.getSpecies();
            double distance = neighbor.distance;
    
            speciesCount.put(species, speciesCount.getOrDefault(species, 0) + 1);
            speciesScore.put(species, speciesScore.getOrDefault(species, 0.0) + (1.0 / (1.0 + distance)));
        }
    
        // Filtrar especies consistentes
        speciesScore.keySet().removeIf(species -> 
            !Trainer.isConsistent(new Node<>(species, convertToStringMap(newCreature.getProperties())))
        );
    
        // Seleccionar especie con mayor puntaje
        return speciesScore.entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("Unknown");
    }
    
    private Map<String, String> convertToStringMap(Map<String, T> properties) {
        Map<String, String> stringMap = new HashMap<>();
        for (Map.Entry<String, T> entry : properties.entrySet()) {
            stringMap.put(entry.getKey(), entry.getValue().toString());
        }
        return stringMap;
    }
    
    // Helper class to store a node and its distance
    private static class NodeDistance<T> {
        Node<T> node;
        double distance;

        public NodeDistance(Node<T> node, double distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
