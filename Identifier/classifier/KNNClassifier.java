import model.PredictionResult;
import model.Node;
import structures.BinaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KNNClassifier<T> {
    private BinaryTree<T> tree;
    private int k;
    private final Map<String, Double> weights = new HashMap<>();

    public KNNClassifier(BinaryTree<T> tree, int k) {
        this.tree = tree;
        this.k = k;

        // Initialize weights for each feature
        weights.put("Size", 0.5);
        weights.put("Skin Type", 5.0);
        weights.put("Habitat", 3.0);
        weights.put("Diet", 1.0);
        weights.put("Blood Type", 3.0);
        weights.put("Reproduction", 4.0);
        weights.put("Lifespan", 1.5);
        weights.put("Defense", 2.0);
        weights.put("Sound", 1.0);
        weights.put("Color Pattern", 1.5);
    }

    public PredictionResult classify(Node<T> newCreature) {
        PriorityQueue<Node<T>> closestNeighbors = new PriorityQueue<>(k, (a, b) -> Double.compare(distance(a, newCreature), distance(b, newCreature)));
        findNeighbors(tree, newCreature, closestNeighbors);

        // Calculate the predicted species and similarity score
        return determineSpeciesWithConfidence(closestNeighbors, newCreature);
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
                    distance += weight;
                }
            } else if (value1 instanceof Number && value2 instanceof Number) {
                double diff = ((Number) value1).doubleValue() - ((Number) value2).doubleValue();
                distance += weight * (diff * diff);
            }
        }

        return Math.sqrt(distance);
    }

    private PredictionResult determineSpeciesWithConfidence(PriorityQueue<Node<T>> neighbors, Node<T> newCreature) {
        Map<String, Double> speciesDistanceSum = new HashMap<>();
        Map<String, Integer> speciesCount = new HashMap<>();

        double totalInverseDistance = 0;

        for (Node<T> neighbor : neighbors) {
            String species = neighbor.getSpecies();
            double dist = distance(neighbor, newCreature);
            double inverseDistance = 1 / (dist + 0.001); // Avoid division by zero

            // Sum the inverse distance for each species
            speciesDistanceSum.put(species, speciesDistanceSum.getOrDefault(species, 0.0) + inverseDistance);
            speciesCount.put(species, speciesCount.getOrDefault(species, 0) + 1);

            totalInverseDistance += inverseDistance;
        }

        // Determine the most probable species and calculate confidence
        String mostProbableSpecies = null;
        double maxSimilarityScore = 0;

        for (Map.Entry<String, Double> entry : speciesDistanceSum.entrySet()) {
            String species = entry.getKey();
            double similarityScore = entry.getValue() / totalInverseDistance;

            if (similarityScore > maxSimilarityScore) {
                mostProbableSpecies = species;
                maxSimilarityScore = similarityScore;
            }
        }

        // Convert similarity score to a percentage
        double confidencePercentage = maxSimilarityScore * 100;

        return new PredictionResult(mostProbableSpecies, confidencePercentage);
    }
}
