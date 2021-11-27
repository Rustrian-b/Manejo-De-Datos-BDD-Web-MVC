<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro de un usuario</title>
        <link rel="stylesheet" href="./css/styleRegistroUsuario.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <img src="./img/logo.png" class="imagen">
        <h1>Registrar usuario</h1>
        
        <form action="registroUsuarios" method="post">
            <p>Ingrese el usuario: <input name="user" type="text" required="" placeholder="Nombre de Usuario" class="respuesta"> </p>
            <p>Ingrese la contraseña: <input name="password" type="password" required="" placeholder="Cree contraseña" class="respuesta"> </p>  
            <input type="submit" value="Registrar usuario" class="boton">
        </form>               
    </body>
</html>

