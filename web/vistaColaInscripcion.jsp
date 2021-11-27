<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estudiantes en la cola</title>
        <link rel="stylesheet" href="./css/styleVistaColaInscripcion.css">
    </head>
    <body>
        <img src="./img/logo.png" class="imagen">
        <h1>Vista de estudiantes en cola de inscripcion</h1>
        <form action="vEstudiantesEnCola" method="post">            
            <input type="submit" value="Recopilar y mostrar estudiantes en cola" class="boton1"> 
        </form><br/><br/>
        
        <table class="container">
            <thead>
                <tr>
                    <th>
                        Carnet
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="lista" items="${sListado}">
                    <tr  class="item">
                        <td class="subitem">
                            ${lista.getvCarnet()}
                        </td>
                    </tr>
                </c:forEach>                                
            </tbody>    
        </table>
        <h2>Inscribir a estudiantes en cola de inscripcion</h2>
        <form action="inscripcionEstudiante" method="post">
            <p>Ingrese Número de Carnet a Inscribir: <input name="carnet" type="text" required="" placeholder="No. Carnet" class="respuesta"></p>
            <input type="submit" value="Registrar Estudiante" class="boton2">
        </form>
        <a href="./main.html">Volver</a>
        <a href="./index.html">Salir</a>
    </body>
</html>
