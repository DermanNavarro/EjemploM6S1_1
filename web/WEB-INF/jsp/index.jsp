<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body style="font-family: arial;">
        <h3>Inicio de Sesion</h3>
        <form action="/EjemploM6S1_1/login" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td>Usuario</td>
                        <td><input type="text" name="txtUsuario" value="" required autofocus/> </td>
                    </tr>
                    <tr>
                        <td>Clave</td>
                        <td><input type="password" name="txtClave" value="" required/> </td>
                    </tr>
                    <tr align="right">
                        <td colspan="2"><input type="submit" value="Entrar" /> </td>
                    </tr>
                </tbody>
            </table>
        </form>
        <a href="<c:url value='/usuarios'/>">Lista de usuarios</a>
        <a href="<c:url value='/registrar'/>">Registrarse</a>
        <h4>${mensaje}</h4>
    </body>
</html>
