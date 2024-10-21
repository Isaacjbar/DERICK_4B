<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar tarea</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body>

<%
    String mensajeError = (session != null) ? (String) session.getAttribute("mensaje") : null;
    if (session != null) {
        if (mensajeError != null) {
%>
<input type="hidden" value="<%=mensajeError%>" id="error">
<%
            session.removeAttribute("mensaje");
        }
    }
%>

/* Estilo general del body */
body {
    background-color: rgba(0, 123, 255, 0.8); /* Fondo azul con transparencia */
    color: white; /* Color de texto blanco */
    font-family: Arial, sans-serif; /* Fuente legible */
    padding: 20px; /* Espaciado interior */
}

/* Estilo del formulario */
#registroTarea {
    background-color: rgba(255, 255, 255, 0.9); /* Fondo blanco con transparencia */
    border-radius: 10px; /* Bordes redondeados */
    padding: 20px; /* Espaciado interior */
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2); /* Sombra sutil */
}

/* Estilo de los inputs y el botón */
input[type="text"],
input[type="date"],
button {
    width: 100%; /* Ancho completo */
    padding: 10px; /* Espaciado interior */
    margin: 10px 0; /* Margen superior e inferior */
    border: 1px solid #ccc; /* Borde gris claro */
    border-radius: 5px; /* Bordes redondeados */
}

/* Estilo del botón */
button {
    background-color: rgba(0, 123, 255, 1); /* Azul sólido */
    color: white; /* Texto blanco */
    border: none; /* Sin borde */
    cursor: pointer; /* Cambia el cursor al pasar por encima */
}

button:hover {
    background-color: rgba(0, 102, 204, 1); /* Azul más oscuro al pasar el mouse */
}

/* Estilo de los labels */
label {
    font-weight: bold; /* Negrita */
    display: block; /* Para que ocupe todo el ancho */
    margin: 10px 0 5px; /* Margen superior e inferior */

}