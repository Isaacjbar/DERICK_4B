package com.intellij.listadetareas.Controller;

import com.intellij.listadetareas.Dao.TareasList;
import com.intellij.listadetareas.Model.Tarea;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/autoDestruccion")
public class LimpiarTareaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        TareasList tareasList = new TareasList();

        if(tareasList.clear()){
            session.setAttribute("mensaje", "Limpia exitosa");
            session.setAttribute("tipo", "Éxito");
            resp.sendRedirect(req.getContextPath() + "/vistaServlet");
        }else {
            session.setAttribute("mensaje", "Limpia no exitosa");
            session.setAttribute("tipo", "Error");
            resp.sendRedirect(req.getContextPath() + "/vistaServlet");
        }
    }
}
