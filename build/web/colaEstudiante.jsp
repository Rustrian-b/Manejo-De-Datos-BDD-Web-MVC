

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estudiantes Registrados</title>
        <link rel="stylesheet" href="./css/styleVistaUsuario.css">
    </head>
    <body>
        <img src="./img/logo.png" class="imagen">
        <h1>Estudiantes ordenados Por fecha de Registro (Antiguo a Reciente)</h1><br/>
        <form action="vEstudiantesReg" method="post">
            <input type="submit" value="Mostrar Estudiantes Inscritos" class="boton">
        </form>
                <table border="4">
            <thead>
                <tr>
                    <th>Carnet</th>
                    <th>Nombre</th>
                </tr>
            </thead>  
            <tbody>
                <c:forEach var="ListaE" items="${sListado}">
                <tr>
                        <td>${ListaE.getvCarnet()}</td>  
                        <td>${ListaE.getvNombre()}</td> 
                </tr>
                </c:forEach>
            </tbody>
        </table>
        
        
    </body>
</html>