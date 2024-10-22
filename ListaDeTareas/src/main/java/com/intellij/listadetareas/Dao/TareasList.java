package com.intellij.listadetareas.Dao;

import com.intellij.listadetareas.Model.Tarea;

import java.util.ArrayList;
import java.util.List;

public class TareasList {
    private static List<Tarea> tareas = new ArrayList<>();

    public boolean add(String nombre, String descripcion, String fecha) {
        for (Tarea tarea : tareas) {
            if (tarea.getNombre().trim().toLowerCase().equals(nombre.trim().toLowerCase())) {
                return false;
            }
        }
        Tarea tarea = new Tarea(nombre, descripcion, fecha, true);
        tareas.add(tarea);
        return true;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public boolean changeStatus(String nombre) {
        for (Tarea tarea : tareas) {
            if (tarea.getNombre().trim().toLowerCase().equals(nombre.trim().toLowerCase())) {
                tarea.setPendiente(!tarea.isPendiente());
                return true;
            }
        }
        return false;
    }

    public int getPendientes() {
        int pendientes = 0;
        for (Tarea tarea : tareas) {
            if (tarea.isPendiente()) {
                pendientes++;
            }
        }
        return pendientes;
    }

    public boolean delete(String nombre) {
        for (int i = 0; i < tareas.size(); i++) {
            Tarea tarea = tareas.get(i);
            if (tarea.getNombre().trim().equalsIgnoreCase(nombre.trim())) {
                tareas.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean clear() {
        if (tareas.isEmpty()) {
            return false;
        }
        tareas.clear();
        return true;
    }

    public boolean contains(String nombre) {
        for (Tarea tarea : tareas) {
            if (tarea.getNombre().trim().equalsIgnoreCase(nombre) && tarea.isPendiente()) {
                return true;
            }
        }
        return false;
    }
}