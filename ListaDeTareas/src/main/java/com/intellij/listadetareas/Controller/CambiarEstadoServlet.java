package com.intellij.listadetareas.Controller;

import com.intellij.listadetareas.Dao.TareasList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/cambiarEstadoServlet")
public class CambiarEstadoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("tarea");
        HttpSession session = req.getSession();

        TareasList tareasList = new TareasList();
        if (tareasList.changeStatus(nombre)) {
            session.setAttribute("mensaje", "Cambio correcto");
            session.setAttribute("tipo", "Éxito");
            resp.sendRedirect(req.getContextPath() + "/vistaServlet");
        } else {
            session.setAttribute("mensaje", "Cambio incorrecto");
            session.setAttribute("tipo", "Error");
            resp.sendRedirect(req.getContextPath() + "/vistaServlet");
        }
    }
}