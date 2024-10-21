package com.intellij.listadetareas.Controller;

import com.intellij.listadetareas.Model.Tarea;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/autoDestruccion")
public class LimpiarTareaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener la lista de tareas de la sesión
        HttpSession session = req.getSession();
        List<Tarea> listaTareas = (List<Tarea>) session.getAttribute("listaTareas");

        // Limpiar la lista de tareas si existe
        if (listaTareas != null) {
            listaTareas.clear();
        }

        // Redirigir de vuelta a la vista de tareas o página principal
        resp.sendRedirect("tareas.jsp"); // Cambia la ruta si es necesario
    }
}
