package com.intellij.listadetareas.Controller;

import com.intellij.listadetareas.Util.TareasList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/registroServlet")
public class RegistroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        String fecha = req.getParameter("fecha");
        HttpSession session = req.getSession();
        
        TareasList tareasList = new TareasList();

        if (tareasList.add(nombre, descripcion, fecha)) {
            session.setAttribute("mensaje", "Registro correcto");
            resp.sendRedirect(req.getContextPath() + "/vistaServlet");
        } else {
            session.setAttribute("mensaje", "Registro incorrecto");
            resp.sendRedirect(req.getContextPath() + "/registro.jsp");
        }
    }
}