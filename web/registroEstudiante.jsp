

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro de un Estudiante</title>
        <link rel="stylesheet" href="./css/styleRegistroEstudiante.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <img src="./img/logo.png" class="imagen">
        <h1>Registrar Estudiante</h1>
        
        <form action="registroEstudiantes" method="post">
            <p>Ingrese Número de Carnet: <input name="carnet" type="text" required="" placeholder="No. Carnet" class="respuesta"> </p>
            <p>Ingrese Nombre: <input name="nombre" type="text" required="" placeholder="Nombre Completo" class="respuesta"> </p> 
            <p>Ingrese Fecha de Nacimiento: <input name="fechanac" type="date" required="" placeholder="Fecha Nacimiento" class="respuesta"> </p>  
            <input type="submit" value="Registrar Estudiante" class="boton">
        </form>               
    </body>
</html>