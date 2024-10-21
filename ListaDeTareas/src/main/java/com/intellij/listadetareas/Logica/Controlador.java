import com.intellij.listadetareas.Model.Tarea;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
/*Logica
public class Controlador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Tarea> lista = new LinkedList<>();
        boolean continuar = true;

        Tarea tareaInicial = new Tarea("Hacer café", "Servirlo en taza grande", "11", false);
        lista.add(tareaInicial);

        ImprimirArchivo(lista);

        while (continuar) {
            int opc;
            System.out.println("1. Agregar tarea" + "\n" +
                               "2. Verificar una tarea" + "\n" +
                               "3. Consultar tareas pendientes" + "\n" +
                               "4. Eliminar tarea" + "\n" +
                               "5. Imprimir la lista completa" + "\n" +
                               "6. Cambiar el estado de una tarea" + "\n" +
                               "7. Imprimir txt" + "\n" +
                               "8. Limpiar" + "\n" +
                               "9. Salir" + "\n");
            opc = sc.nextInt();
            sc.nextLine(); 

            switch (opc) {
                case 1:
                    
                    Tarea nuevaTarea = new Tarea();
                    System.out.println("Nombre de la tarea: ");
                    nuevaTarea.setName(sc.nextLine());
                    System.out.println("Descripción: ");
                    nuevaTarea.setDescription(sc.nextLine());
                    System.out.println("Fecha: ");
                    nuevaTarea.setDate(sc.nextLine());
                    System.out.println("Estado: ");
                    while (!sc.hasNextBoolean()) {

                        sc.next(); 
                    }
                    nuevaTarea.setStatus(sc.nextBoolean());
                    sc.nextLine(); 
                    lista.add(nuevaTarea);
                    System.out.println("Tarea agregada correctamente.");
                    ImprimirArchivo(lista); 
                    break;

                case 2:
                    System.out.println("Nombre de la tarea a verificar:");
                    String nombreVerificar = sc.nextLine();
                    boolean existe = false;
                    for (Tarea tarea : lista) {
                        if (tarea.getName().equals(nombreVerificar)) {
                            System.out.println(tarea.toString());
                            existe = true;
                            break;
                        }
                    }
                    if (!existe) {
                        System.out.println("La tarea no existe.");
                    }
                    break;

                case 3:
                    int pendientes = 0;
                    for (Tarea tarea : lista) {
                        if (!tarea.getStatus()) {
                            pendientes++;
                        }
                    }
                    System.out.println("Hay " + pendientes + " tareas pendientes.");
                    break;

                case 4:
                    System.out.println("Nombre de la tarea a eliminar:");
                    String nombreEliminar = sc.nextLine();
                    Tarea tareaAEliminar = null;
                    for (Tarea tarea : lista) {
                        if (tarea.getName().equals(nombreEliminar)) {
                            tareaAEliminar = tarea;
                            break;
                        }
                    }
                    if (tareaAEliminar != null) {
                        lista.remove(tareaAEliminar);
                        System.out.println("La tarea " + nombreEliminar + " ha sido eliminada.");
                        ImprimirArchivo(lista); 
                    } else {
                        System.out.println("La tarea no existe.");
                    }
                    break;

                case 5:
                    System.out.println("Lista completa de tareas:");
                    for (Tarea tarea : lista) {
                        System.out.println(tarea);
                    }
                    break;

                case 6:
                    System.out.println("Nombre de la tarea para cambiar el estado:");
                    String nombreEstado = sc.nextLine();
                    Tarea tareaCambiarEstado = null;
                    for (Tarea tarea : lista) {
                        if (tarea.getName().equals(nombreEstado)) {
                            tareaCambiarEstado = tarea;
                            break;
                        }
                    }
                    if (tareaCambiarEstado != null) {
                        System.out.println("Estado actual: " + (tareaCambiarEstado.getStatus() ? "Completada" : "Pendiente"));
                        System.out.println("Nuevo estado: ");
                        while (!sc.hasNextBoolean()) {
                            sc.next(); 
                        }
                        tareaCambiarEstado.setStatus(sc.nextBoolean());
                        sc.nextLine(); 
                        System.out.println("El estado de la tarea " + nombreEstado + " ha sido cambiado.");
                        ImprimirArchivo(lista); 
                    } else {
                        System.out.println("La tarea no existe.");
                    }
                    break;
                case 7:
                    ImprimirArchivo(lista);
                break;
                case 8:
                    lista.clear();
                break;
                case 9:
                    continuar = false;
                    System.out.println("Saliste del programa");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public static void ImprimirArchivo(List<Tarea> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("tareas.txt"))) {
            for (Tarea tarea : lista) {
                bw.write(tarea.toString());
                bw.newLine();
            }
            System.out.println("Archivo generado exitosamente.");
        } catch (IOException e) {
            System.out.println("Algo malo ha ocurrido al generar el archivo.");
        }
    }
}*/
