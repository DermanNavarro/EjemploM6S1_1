<%-- 
    Document   : usuario
    Created on : 03-04-2017, 02:02:13 PM
    Author     : Derman N
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style='font-family: arial;'>
        <h3>${mensaje}</h3><br>
        <input type='submit' onclick="location='registrar'" value='Agregar usuario'/><br>
        <table border="0" cellspacing='10'>
            <thead>
                <tr>
                    <th>Usuario</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>email</th>
                    <th>Telefono</th>
                    <th>Pais</th>
                    <th>Rol</th>
                    <th>Eliminar</th>
                    <th>Editar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${usuarios}" var="u">
                <tr>
                    <td>${u.idusuario}</td>
                    <td>${u.nombres}</td>
                    <td>${u.apellidos}</td>
                    <td>${u.email}</td>
                    <td>${u.telefono}</td>
                    <td>${u.pais.pais}</td>
                    <td>${u.rol.rol}</td>
                    <td><input type='submit' onclick="location='delUsuario/${u.idusuario}'" value='Eliminar'/></td>
                    <td><input type='submit' onclick="location='modUsuario/${u.idusuario}'" value='Modificar'/></td>
                    <td></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
