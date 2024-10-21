package com.intellij.listadetareas.Util;

import com.intellij.listadetareas.Model.Tarea;

import java.util.ArrayList;
import java.util.List;

public class TareasList {
    private static List<Tarea> tareas = new ArrayList<>();

    public boolean add(String nombre, String descripcion, String fecha) {
        Tarea tarea = new Tarea(nombre, descripcion, fecha, true);
        tareas.add(tarea);
        return true;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }
}