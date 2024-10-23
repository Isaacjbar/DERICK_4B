<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Menu</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="css/menu.css">
</head>
<body>
<%
    String ruta = request.getContextPath();
%>
<div class="container">
    <table>
        <thead>
        <tr>
            <th colspan="2">Menú</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td><a href="registro.jsp">Agregar tarea</a></td>
                <td><i class="bi bi-pen-fill"></i></td>
            </tr>
            <tr>
                <td><a href="existencia.jsp">Verificar existencia y estado de una tarea</a></td>
                <td><i class="bi bi-calendar2-check-fill"></i></td>
            </tr>
            <tr>
                <td><a href="<%=ruta%>/vistaServlet">Ver lista completa de tareas</a></td>
                <td><i class="bi bi-journal-bookmark-fill"></i></td>
            </tr>
            <tr>
                <td><a href="<%=ruta%>/descargarTxt">Imprimir en txt</a></td>
                <td><i class="bi bi-filetype-txt"></i></i></td>
            </tr>
            <tr>
                <td> <a href="<%=ruta%>/autoDestruccion">Limpiar lista</a></td>
                <td><i class="bi bi-eraser-fill"></i></td>
            </tr>

        </tbody>
    </table>
    </div>
<script src="js/bootstrap.js"></script>
</body>
</html>