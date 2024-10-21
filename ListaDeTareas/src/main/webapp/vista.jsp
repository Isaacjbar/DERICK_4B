<%@ page import="com.intellij.listadetareas.Model.Tarea" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta charset="UTF-8">
    <title>Vista de tareas</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body>

<%
    List<Tarea> tareas = (List<Tarea>) session.getAttribute("tareas");
%>

<ul class="nav nav-tabs mb-4" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" data-toggle="tab" href="#tareas_pendientes" role="tab">Tareas pendientes</a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" data-toggle="tab" href="#tareas_realizadas" role="tab">Tareas realizadas</a>
    </li>
    <li>
        <a href="/menu.jsp">Regresar</a>
    </li>
</ul>

<div class="tab-content">
    <div class="tab-pane show active" id="tareas_pendientes" role="tabpanel">
        <div class="row justify-content-center">
            <div class="col-md-10">
                <div class="list-group" id="pendientes">
                    <%
                        for (Tarea tarea : tareas) {
                            if (tarea.isPendiente()) {
                    %>
                    <div class="list-group-item d-flex justify-content-between align-items-center shadow-inner order-card">
                        <div>
                            <p><strong>Nombre: </strong><%=tarea.getNombre()%>
                            </p>
                            <p><strong>Descripción: </strong><%=tarea.getDescripcion()%>
                            </p>
                            <p><strong>Fecha: </strong><%=tarea.getFecha()%>
                            </p>
                        </div>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="tab-content">
    <div class="tab-pane show active" id="tareas_realizadas" role="tabpanel">
        <div class="row justify-content-center">
            <div class="col-md-10">
                <div class="list-group" id="realizadas">

                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/bootstrap.js"></script>
</body>
</html>
