package jbar.creature_identifier.controller;

import jbar.creature_identifier.model.Animal;
import jbar.creature_identifier.service.BinaryTree;
import jbar.creature_identifier.service.KnnClassifier;
import jbar.creature_identifier.util.CsvParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final BinaryTree binaryTree = new BinaryTree();
    private final KnnClassifier knnClassifier = new KnnClassifier();

    // Método para cargar el archivo CSV
    @PostMapping("/upload")
    public ResponseEntity<?> uploadCsv(@RequestParam("file") MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            // Parsear el CSV y crear los animales a partir de los datos
            List<Animal> animals = CsvParser.parseCsv(reader);

            // Validar que los datos sean coherentes (opcional, dependiendo de los casos que necesites)
            animals.forEach(animal -> {
                if (animal.getSpecie() < 1 || animal.getSpecie() > 6) {
                    throw new IllegalArgumentException("Especie inválida: " + animal.getSpecie());
                }
            });

            // Agregar cada animal al árbol binario
            animals.forEach(binaryTree::add);

            // Retornar la información completa de los animales cargados
            return ResponseEntity.ok(animals);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al procesar el archivo: " + e.getMessage());
        }
    }

    // Método para clasificar un animal basado en el KNN
    @PostMapping("/classify")
    public ResponseEntity<?> classify(@RequestBody Animal input) {
        List<Animal> trainingSet = binaryTree.toList();

        if (trainingSet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El conjunto de entrenamiento está vacío.");
        }

        // Calcular la especie del animal utilizando el clasificador KNN
        int predictedSpecie = knnClassifier.classify(input, trainingSet, 3); // Ahora la especie es un int
        input.setSpecie(predictedSpecie); // Ajuste para que `specie` sea un int
        return ResponseEntity.ok(input);
    }
}
