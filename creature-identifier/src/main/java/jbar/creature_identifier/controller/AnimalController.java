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

    @PostMapping("/upload")
    public ResponseEntity<?> uploadCsv(@RequestParam("file") MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            List<Animal> animals = CsvParser.parseCsv(reader);

            // Agregar cada animal al árbol binario
            animals.forEach(binaryTree::add);

            // Retornar la información completa de los animales cargados
            return ResponseEntity.ok(animals);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al procesar el archivo: " + e.getMessage());
        }
    }

    @PostMapping("/classify")
    public ResponseEntity<?> classify(@RequestBody Animal input) {
        List<Animal> trainingSet = binaryTree.toList();
        if (trainingSet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El conjunto de entrenamiento está vacío.");
        }

        // Calcular la especie del animal utilizando el clasificador
        String predictedSpecie = knnClassifier.classify(input, trainingSet, 3);
        input.setSpecie(predictedSpecie); // Establecer la especie generada en el objeto input

        // Retornar el animal con la especie generada
        return ResponseEntity.ok(input);
    }



}