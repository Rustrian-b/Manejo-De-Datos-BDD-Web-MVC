<%-- 
    Document   : vistaIncripcion
    Created on : 29/10/2021, 10:19:47 AM
    Author     : H4HG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estudiantes inscritos</title>
        <link rel="stylesheet" href="./css/styleVistaInscripcion.css">
    </head>
    <body>
        <img src="./img/logo.png" class="imagen">
        <h1>Estudiantes inscritos, ordenados Por fecha de Registro (Antiguo a Reciente)</h1><br/>
        <form action="vEstudiantesInscritos" method="post">
            <input type="submit" value="Mostrar estudiates inscritos" class="boton">
        </form>
        <table border="4">
            <thead>
                <tr>
                    <th>Carnet</th>                    
                </tr>
            </thead>  
            <tbody>
                <c:forEach var="lista" items="${sListado}">
                    <tr>
                        <td class="subitem">${lista.getCarnet()}</td>                          
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="./main.html">Volver</a> 
    </body>
</html>
