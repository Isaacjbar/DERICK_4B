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
        // Si el árbol está vacío, devuelve un nuevo nodo
        if (current == null) {
            return new Node(animal);
        }

        // Compara el tamaño del animal y decide a qué lado agregarlo
        if (animal.getSize() < current.animal.getSize()) {
            current.left = addRecursive(current.left, animal);
        } else if (animal.getSize() > current.animal.getSize()) {
            current.right = addRecursive(current.right, animal);
        } else {
            // Si el tamaño es el mismo, no agregamos duplicados
            return current;
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
