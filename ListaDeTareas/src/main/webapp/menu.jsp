<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Menu</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%
    String ruta = request.getContextPath();
%>
<nav>
    <ul class="menu">
        <li>
            <a href="registro.jsp">Agregar tarea</a>
        </li>
        <li>
            <a href="existencia.jsp">Verificar existencia y estado de una tarea</a>
        </li>
        <li>
            <a href="<%=ruta%>/vistaServlet">Imprimir la lista completa</a>
        </li>
        <li>
            <a href="<%=ruta%>/descargarTxt">Imprimir en txt</a>
        </li>
        <li>
            <a href="<%=ruta%>/autoDestruccion">Limpiar lista</a>
        </li>
    </ul>
</nav>
<script src="js/bootstrap.js"></script>
</body>
</html>