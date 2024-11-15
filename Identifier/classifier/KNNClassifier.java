import model.Node;
import structures.BinaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KNNClassifier<T> {
    private BinaryTree<T> tree;
    private int k;

    // Weights for each feature
    private final Map<String, Double> weights = new HashMap<>();

    public KNNClassifier(BinaryTree<T> tree, int k) {
        this.tree = tree;
        this.k = k;
        
        // Initialize weights for each feature
        weights.put("Size", 0.5);       // Less impactful
        weights.put("Skin Type", 5.0);  // High impact
        weights.put("Habitat", 3.0);    // Moderate impact
        weights.put("Diet", 1.0);       // Moderate impact
        weights.put("Behavior", 0.5);   // Less impactful
    }

    public String classify(Node<T> newCreature) {
        PriorityQueue<Node<T>> closestNeighbors = new PriorityQueue<>(k, (a, b) -> Double.compare(distance(a, newCreature), distance(b, newCreature)));
        findNeighbors(tree, newCreature, closestNeighbors);
        return determineSpecies(closestNeighbors);
    }

    private void findNeighbors(BinaryTree<T> tree, Node<T> node, PriorityQueue<Node<T>> neighbors) {
        if (tree == null) return;

        neighbors.add(tree.getNode());
        if (neighbors.size() > k) {
            neighbors.poll();
        }

        findNeighbors(tree.getLeft(), node, neighbors);
        findNeighbors(tree.getRight(), node, neighbors);
    }

    private double distance(Node<T> node1, Node<T> node2) {
        double distance = 0;

        for (String key : node1.getProperties().keySet()) {
            T value1 = node1.getProperty(key);
            T value2 = node2.getProperty(key);
            double weight = weights.getOrDefault(key, 1.0);

            if (value1 instanceof String && value2 instanceof String) {
                if (!value1.equals(value2)) {
                    distance += weight * 1;  // Penalization for different categorical properties
                }
            } else if (value1 instanceof Number && value2 instanceof Number) {
                double diff = ((Number) value1).doubleValue() - ((Number) value2).doubleValue();
                distance += weight * (diff * diff);
            }
        }

        return Math.sqrt(distance);
    }

    private String determineSpecies(PriorityQueue<Node<T>> neighbors) {
        Map<String, Integer> speciesCount = new HashMap<>();

        for (Node<T> neighbor : neighbors) {
            String species = neighbor.getSpecies();
            speciesCount.put(species, speciesCount.getOrDefault(species, 0) + 1);
        }

        String mostCommonSpecies = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : speciesCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommonSpecies = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostCommonSpecies;
    }
}
