<%@ page import="com.intellij.listadetareas.Model.Tarea" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vista de tareas</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <link rel="stylesheet" href="css/vista.css">
</head>
<body>
<%
    String mensajeError = (session != null) ? (String) session.getAttribute("mensaje") : "";
    String tipoMensaje = (session != null) ? (String) session.getAttribute("tipo") : "";
    String ruta = request.getContextPath();
    Integer pendientesObj = (session != null) ? (Integer) session.getAttribute("pendientes") : null;
    int pendientes = (pendientesObj != null) ? pendientesObj : 0;

    List<Tarea> tareas = (List<Tarea>) (session != null ? session.getAttribute("tareas") : new ArrayList<>());

    if (session != null) {
        if (mensajeError != null) {
%>
<input type="hidden" value="<%=mensajeError%>" id="error">
<input type="hidden" value="<%=tipoMensaje%>" id="tipo">
<%
            session.removeAttribute("mensaje");
            session.removeAttribute("tipo");
        }
    }
%>

<div class="left-button">
    <a href="<%=ruta%>/menu.jsp" class="left-button">Regresar</a>
</div>

<ul class="nav nav-tabs mb-4 centered-tabs" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" id="tareas-pendientes-tab" data-toggle="tab" href="#tareas-pendientes" role="tab"
           aria-controls="tareas-pendientes" aria-selected="true">Tareas pendientes</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="tareas-realizadas-tab" data-toggle="tab" href="#tareas-realizadas" role="tab"
           aria-controls="tareas-realizadas" aria-selected="false">Tareas realizadas</a>
    </li>
</ul>

<div class="right-aligned">
    <strong>Tareas pendientes: </strong><%=pendientes%>
</div>

<div class="tab-content">
    <div class="tab-pane fade show active" id="tareas-pendientes" role="tabpanel"
         aria-labelledby="tareas-pendientes-tab">
        <div class="row justify-content-center">
            <div class="col-md-10">
                <div class="list-group" id="pendientes">
                    <%
                        if (tareas != null) {
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
                        <div class="btn-group">
                            <form class="d-inline" id="cambiarForm" action="cambiarEstadoServlet" method="post">
                                <input type="hidden" name="tarea" value="<%=tarea.getNombre()%>">
                                <button class="btn btn-success btn-sm mr-2" id="cambiarButton">Cambiar estado</button>
                            </form>
                            <form class="d-inline" id="eliminarForm" action="eliminarTareaServlet" method="post">
                                <input type="hidden" name="tarea" value="<%=tarea.getNombre()%>">
                                <button class="btn btn-danger btn-sm" id="eliminarButton">Eliminar tarea</button>
                            </form>
                        </div>
                    </div>
                    <%
                                }
                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </div>

    <div class="tab-pane fade" id="tareas-realizadas" role="tabpanel" aria-labelledby="tareas-realizadas-tab">
        <div class="row justify-content-center">
            <div class="col-md-10">
                <div class="list-group" id="realizadas">
                    <%
                        if (tareas != null) {
                            for (Tarea tarea : tareas) {
                                if (!tarea.isPendiente()) {
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
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="js/alertas.js"></script>
<script src="js/eliminar.js"></script>
<script src="js/actualizar.js"></script>
</body>
</html>