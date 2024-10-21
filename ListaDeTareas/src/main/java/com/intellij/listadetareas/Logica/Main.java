package com.intellij.listadetareas.Logica;
/*
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
//Los siguientes paquetes son de IO (input/output)
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
    // Aquí se hace el ejercicio UIII_E2
    private static String nombre, descripcion, fecha;
    private static boolean estado = false;

    static Scanner scanner = new Scanner(System.in);
    static List<Tarea> lista = new LinkedList<>();

    public static void main(String[] args) {
        // Instalar mi linkedlist de tareas


          Tarea tareaUan = new Tarea("Lavar la ropa", "Hay que lavar la ropa",
          "24/05/2021", true);
          Tarea tareaTwo = new Tarea("Sacar la basura", "El camion pasa a las 7:00 am",
          "14/10/2024", true);

          lista.add(tareaUan);
          lista.add(tareaTwo);
          imprimirArchivo(lista);

        // Un ciclo infinito donde hay opciones de menú
        // while()
        // switch()

        boolean salir = true;
        while (salir) {
            System.out.println(
                    "Ingresa una opción\n1. Agregar tarea\n2. Verificar estado de las tareas\n3. Consultar el número de tareas\n4. Eliminar tareas\n5. Imprimir la lista de tareas pendintes\n6. Limpiar la lista\n7. Cambiar estado\n8. Convertir la lista a un txt\n9. Salir");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    add();
                    break;
                case 2:
                    contains();
                    break;
                case 3:
                    tareasPendientes();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    pendiente();
                    break;
                case 6:
                    lista.clear();
                    break;
                case 7:
                    cambiarEstado();
                    break;
                case 8:
                    imprimirArchivo(lista);
                    break;
                case 9:
                    salir = false;
                    break;
                default:
                    break;
            }
        }
    }

    private static void add() {
        System.out.println("Ingresa un nombre");
        nombre = scanner.next();
        System.out.println("Ingresa una descripcion");
        descripcion = scanner.next();
        System.out.println("Ingresa una fecha");
        fecha = scanner.next();
        estado = true;
        Tarea tarea = new Tarea(nombre, descripcion, fecha, estado);
        lista.add(tarea);
    }

    private static void contains() {
        System.out.println("Ingresa nombre");
        nombre = scanner.next();
        for (Tarea tarea : lista) {
            if (tarea.getNombre().equals(nombre) && tarea.isPendiente()) {
                System.out.println("La tarea existe y esta activa");
            }
        }
    }

    private static void tareasPendientes() {
        int hechas = 0, pendintes = 0;
        for (Tarea tarea : lista) {
            if (tarea.isPendiente()) {
                pendintes++;
            } else {
                hechas++;
            }

        }
        System.out.println("Tareas pendientes " + pendintes);
        System.out.println("Tareas hechas " + hechas);
    }

    private static void pendiente() {
        for (Tarea tarea : lista) {
            if (tarea.isPendiente()) {
                System.out.println("La tarea " + tarea.getNombre() + " esta pendintes");
            } else {
                System.out.println("La tarea " + tarea.getNombre() + " esta hecha");
            }
        }
    }

    private static void eliminar() {
        System.out.println("Ingresa el indice a eliminar");
        int index = scanner.nextInt();
        if (index >= lista.size() || lista.size() == 0 || index < 0) {
            System.out.println("Indice no válido");
            return;
        }
        lista.remove(index);
    }

    private static void cambiarEstado() {
        System.out.println("Ingresa el nombre a cambiar");
        String nombre = scanner.next();

        for (Tarea tarea : lista) {
            if (tarea.getNombre().equals(nombre)) {
                tarea.setPendiente(!tarea.isPendiente());
            }
        }
    }

    public static void imprimirArchivo(List<Tarea> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Vanessa.txt", true))) {
            // Estamos dentro de las llaves del try
            for (Tarea tarea : lista) {
                bw.write(tarea.toString());
                bw.newLine();
                bw.newLine();
            }
            System.out.println("Archivo generado exitosamente");
        } catch (IOException ioException) {
            System.out.println("Algo malo ocurrió :(");
        }
    }

}*/