<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav>
    <ul class="menu">
        <li>
            <a href="registro.jsp">Agregar tarea</a>
        </li>
        <li>
            <a href="">Verificar una tarea</a>
        </li>
        <li>
            <a href="">Consultar tareas pendientes</a>
        </li>
        <li>
            <a href="">Eliminar tarea</a>
        </li>
        <li>
            <%String ruta = request.getContextPath() + "/vistaServlet";%>
            <a href="<%=ruta%>">Imprimir la lista completa</a>
        </li>
        <li>
            <a href="">Cambiar el estado de una tarea</a>
        </li>
        <li>
            <a href="">Imprimir en txt</a>
        </li>
        <li>
            <a href="">Limpiar</a>
        </li>
    </ul>
</nav>
</body>
</html>
