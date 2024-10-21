package com.intellij.listadetareas.Controller;

import com.intellij.listadetareas.Model.Tarea;
import com.intellij.listadetareas.Util.TareasList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/vistaServlet")
public class vistaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        TareasList tareasList = new TareasList();
        List<Tarea> tareas = tareasList.getTareas();

        session.setAttribute("tareas", tareas);
        resp.sendRedirect(req.getContextPath() + "/vista.jsp");
    }
}