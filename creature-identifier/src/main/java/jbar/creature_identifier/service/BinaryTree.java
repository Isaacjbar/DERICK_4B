package jbar.creature_identifier.service;

import jbar.creature_identifier.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private Node root;

    private static class Node {
        Animal animal;
        Node left;
        Node right;

        Node(Animal animal) {
            this.animal = animal;
        }
    }

    public void add(Animal animal) {
        root = addRecursive(root, animal);
    }

    private Node addRecursive(Node current, Animal animal) {
        if (current == null) {
            return new Node(animal);
        }
        // Comparación personalizada (puedes usar propiedades como tamaño o dieta para organizar)
        if (animal.getSize().compareTo(current.animal.getSize()) < 0) {
            current.left = addRecursive(current.left, animal);
        } else {
            current.right = addRecursive(current.right, animal);
        }
        return current;
    }

    public List<Animal> toList() {
        List<Animal> animals = new ArrayList<>();
        inOrderTraversal(root, animals);
        return animals;
    }

    private void inOrderTraversal(Node node, List<Animal> animals) {
        if (node != null) {
            inOrderTraversal(node.left, animals);
            animals.add(node.animal);
            inOrderTraversal(node.right, animals);
        }
    }
}
