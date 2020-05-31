<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Productos</h1>
        <p><a href="Inicio?action=add">Nuevo Producto</a></p>
        
        <table border="1">
            
            <tr>
                <th>ID</th>
                <th>Titulo</th>
                <th>Contenido</th>
                <th></th>
                <th></th>
                
            </tr>
            <c:forEach var="item" items="${productos}">
             <tr>
                <td>${item.id}</td>
                <td>${item.descripcion}</td>
                <td>${item.stock}</td>
                <td><a href="Inicio?action=edit&id=${item.id}">Editar</a></td>
                <td><a href="Inicio?action=delete&id=${item.id} "onclick="return(confirm('Esta seguro'))">Eliminar</a></td>               
            </tr>
            </c:forEach>
        </table>
    </center>
        
    </body>
</html>
