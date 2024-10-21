package com.intellij.listadetareas.Controller;
import com.intellij.listadetareas.Model.Tarea;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/descargarTxt")
public class DescargarTxtServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener la lista de tareas de la sesión
        HttpSession session = req.getSession();
        List<Tarea> listaTareas = (List<Tarea>) session.getAttribute("listaTareas");

        // Configurar la respuesta como archivo de texto
        resp.setContentType("text/plain");
        resp.setHeader("Content-Disposition", "attachment;filename=tareas.txt");

        // Escribir la lista de tareas en el archivo
        if (listaTareas != null && !listaTareas.isEmpty()) {
            for (Tarea tarea : listaTareas) {
                resp.getWriter().write(tarea.toString() + "\n");
            }
        } else {
            resp.getWriter().write("No hay tareas en la lista.\n");
        }

        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
/*<!DOCTYPE html>
<html>
<head>
    <title>Lista de Tareas</title>
</head>
<body>
    <h1>Gestión de Tareas</h1>

    <!-- Botón para limpiar la lista de tareas -->
    <form action="autoDestruccion" method="get">
        <button type="submit">Botón de auto destrucción</button>
    </form>

    <!-- Botón para descargar la lista como archivo .txt -->
    <form action="descargarTxt" method="get">
        <button type="submit">Descargar Lista (TXT)</button>
    </form>

    <!-- Aquí puedes agregar otros elementos como la lista de tareas, agregar tareas, etc. -->
</body>
</html>

*/
