package com.intellij.listadetareas.Controller;

import com.intellij.listadetareas.Util.TareasList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/vistaServlet")
public class vistaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TareasList tareasList = new TareasList();
        resp.sendRedirect(req.getContextPath() + "/vista.jsp");
    }
}