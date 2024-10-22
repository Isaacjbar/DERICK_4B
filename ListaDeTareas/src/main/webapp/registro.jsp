<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar tarea</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/styles.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<%
    String mensajeError = (session != null) ? (String) session.getAttribute("mensaje") : "";
    String tipoMensaje = (session != null) ? (String) session.getAttribute("tipo") : "";
    String ruta = request.getContextPath();
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
<header>
    <a href="<%=ruta%>/menu.jsp">Regresar</a>
</header>
<body>
<form id="registroTarea" action="registroServlet" method="post">
    <label for="nombre">Introduce el nombre</label>
    <input id="nombre" type="text" maxlength="50" name="nombre" placeholder="Ingresa el nombre">
    <br>
    <br>
    <label for="descripcion">Introduce la descripción</label>
    <input id="descripcion" type="text" maxlength="120" name="descripcion" placeholder="Ingresa la descripción">
    <br>
    <br>
    <label for="fecha">Selecciona la fecha</label>
    <input id="fecha" type="date" name="fecha">
    <br>
    <br>
    <button id="registrar" type="submit">Registrar tarea</button>
</form>
<script src="js/bootstrap.js"></script>
<script src="js/formulario.js"></script>
<script src="js/alertas.js"></script>
</body>
</html>