package com.intellij.listadetareas.Controller;

import com.intellij.listadetareas.Dao.TareasList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/verificarTareaServlet")
public class VerificarTareaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tarea = req.getParameter("tarea");
        HttpSession session = req.getSession();
        TareasList tareasList = new TareasList();

        if (tareasList.contains(tarea)) {
            session.setAttribute("mensaje", "La tarea existe y esta activa");
            session.setAttribute("tipo", "Éxito");
            resp.sendRedirect(req.getContextPath() + "/existencia.jsp");
        } else {
            session.setAttribute("mensaje", "La tarea no existe o no esta pendiente");
            session.setAttribute("tipo", "Error");
            resp.sendRedirect(req.getContextPath() + "/existencia.jsp");
        }
    }
}
