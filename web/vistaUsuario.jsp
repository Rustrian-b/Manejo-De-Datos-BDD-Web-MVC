<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios existentes</title>
        <link rel="stylesheet" href="./css/styleVistaUsuario.css">
    </head>
    <body>
        <img src="./img/logo.png" class="imagen">
        <h1>Vista de usuarios existentes en el sistema</h1><br/>
        <form action="vUsuarios" method="post">
            <input type="submit" value="Recopilar y mostrar usuarios existentes" class="boton">
        </form><br/><br/>
        
        <table>
            <thead>
                <tr>
                    <th>
                        Usuarios
                    </th>
                </tr>                
            </thead>
            <tbody class="container">
                <c:forEach var="lista" items="${sListado}">
                    <tr class="item">
                        <td class="subitem">
                            ${lista.getvUsuario()}
                        </td>
                    </tr>
                </c:forEach>
            </tbody>            
        </table>
        <a href="./main.html">Volver</a>
    </body>
</html>
