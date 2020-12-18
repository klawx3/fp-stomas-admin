<%--
    Author     : Marcelo Gatica Contreras
--%>
<%@page import="database.model.DBHistory"%>
<%@page import="java.util.Optional"%>
<%@page import="java.util.List"%>
<%@page import="database.model.DBUser"%>
<%@page import="database.dao.impl.UserDaoImpl"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">
        <title>Editar Registros</title>
    </head>
    <body>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>

        <div class="columns">
            <div class="column is-5"></div>
            <div class="column is-4">



                <%
                    int idUser = Integer.parseInt(request.getParameter("idUser"));

                    UserDaoImpl udi = new UserDaoImpl();
                    List<DBUser> userList = udi.getUserById(idUser);

                    for (DBUser d : userList) {
                %><h1 class="title"> Editar registro de: <br><br><%= d.getFullname()%></h1><%

                    %>



                <form action="actualizarUser.do" method="post">
                    <input type="hidden" name="idUser" value="<%= d.getId()%>">
                    <label class="label">Nombre: </label>
                    <input class="input is-rounded" type="text" name="nameUser" value="<%= d.getFullname()%>">
                    <br>
                    <br>
                    <label class="label">Rut: </label>
                    <input class="input is-rounded" type="text" name="rut" value="<%= d.getRut()%>">
                    <br>
                    <br>
                    <input class="button is-rounded is-danger is-hoverable is-fullwidth" type="submit" value="Actualizar">
                </form>
                <% }%>

            </div>
            <div class="column is-5"></div>
        </div>




    </body>
</html>
