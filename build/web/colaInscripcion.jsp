<%-- 
    Document   : colaInscripcion
    Created on : 28/10/2021, 10:20:13 AM
    Author     : H4HG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cola de estudiantes</title>
        <link rel="stylesheet" href="./css/styleColaInscripcion.css">
    </head>
    <body>
        <img src="./img/logo.png" class="imagen">
        <h1>Agregar estudiante registrado a la cola de inscripcion</h1>
        <form action="vEstudiantesCola" method="post">
            <input type="submit" value="Generar proximo estudiante a agregar a cola de inscripcion" class="boton1">
        </form>
        <table>
            <thead>
                <tr>
                    <th>Carnet</th>
                    <th>Nombre</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="lista" items="${sListado}">
                    <tr>
                        <td class="subitem">${lista.getvCarnet()}</td>
                        <td class="subitem">${lista.getvNombre()}</td>
                        <form action="registroCola" method="post">
                            <input type="hidden" name="ctCarnet" value ="${lista.getvCarnet()}" id="inputText2"><br>
                            <input type="submit" value="Agregar a cola de estudiantes" class="boton2">
                        </form>                        
                    </tr>                    
                </c:forEach>
            </tbody>            
        </table>
        <a href="./main.html">Volver</a>
    </body>
</html>
