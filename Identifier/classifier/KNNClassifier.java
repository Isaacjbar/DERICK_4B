import model.Node;
import structures.BinaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KNNClassifier<T> {
    private BinaryTree<T> tree;
    private int k;

    public KNNClassifier(BinaryTree<T> tree, int k) {
        this.tree = tree;
        this.k = k;
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

            if (value1 instanceof String && value2 instanceof String) {
                // Categorical property comparison
                if (!value1.equals(value2)) {
                    distance += 1;
                }
            } else if (value1 instanceof Number && value2 instanceof Number) {
                // Numerical property comparison (Euclidean distance)
                double diff = ((Number) value1).doubleValue() - ((Number) value2).doubleValue();
                distance += diff * diff;
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
