<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Existencia y estado de una tarea</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/buscar.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<%
    String mensajeError = (session != null) ? (String) session.getAttribute("mensaje") : "";
    String tipoMensaje = (session != null) ? (String) session.getAttribute("tipo") : "";
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
<body>
<a href="<%=request.getContextPath()%>/menu.jsp" class="back-link">Regresar</a>
<div class="container">
    <h1>Búsqueda de Tareas</h1>
<form id="buscarForm" action="verificarTareaServlet" method="post">
    <label for="tarea">Ingresa el nombre de la tarea</label>
    <input type="text" id="tarea" name="tarea" maxlength="50" placeholder="Ingresa el nombre de la tarea">
    <button type="submit" id="buscarButton">Buscar</button>
</form>
</div>
<script src="js/buscar.js"></script>
</body>
</html>
