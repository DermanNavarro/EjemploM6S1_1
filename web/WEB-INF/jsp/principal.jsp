<%-- 
    Document   : principal
    Created on : 03-04-2017, 02:02:31 PM
    Author     : Derman N
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Bienvinido a Sprint</h3>
        <%
            HttpSession s = request.getSession();
            %>
            usuario:<%=s.getAttribute("usuario")%><br>
            usuario:<%=s.getAttribute("nombre")%><br>
            usuario:<%=s.getAttribute("correo")%><br>
            usuario:<%=s.getAttribute("idrol")%><br>
            
            <a href="<c:url value='/listarusuarios'/>">listado de Usuarios</a><br>
            <a href="<c:url value='/cerrarsesion'/>">Cerrar Sesion</a><br>
    </body>
</html>
