<%--
    Author     : Marcelo Gatica Contreras
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="database.model.DBHistory"%>
<%@page import="database.dao.impl.HistoryDaoImpl"%>
<%@page import="database.Conexion"%>
<%@page import="config.FPConfig"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css"> 
        <title>Todos los registros</title>
    </head>
    <body>


        <%
            HistoryDaoImpl daoImpl = new HistoryDaoImpl();
        %>





        <div class="columns">
            <div class="column is-5"></div>
            <div class="column is-2">
                <h1 class="title is-centered">Todos los registros</h1>
            </div>
            <div class="column is-5"></div>
        </div>


        <div class="columns">
            <div class="column is-2"></div>
            <div class="column is-8">


                <table class= "table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
                    <tr>
                        <th>Nombre</th>
                        <th>Rut</th>
                        <th>Fecha Registro</th>
                        <th>Editar</th>

                    </tr>
                    <%for (DBHistory record : daoImpl.getAll()) {%>

                    <tr>
                        <th><%= record.getUserName()%></th>
                        <th><%= record.getUserRut()%></th>
                        <th><%= record.getRegisterDate()%></th>
                        <th><form action="editarRegistro.jsp">
                                <input type="hidden" value="<%= record.getUserId()%>" name="idUser">

                                <button type="submit" class="button is-rounded is-warning is-hoverable">Editar Registro</button></form>
                        </th>

                    </tr>
                    <%}%> 

                    <p class='select-css' id='nombre' name='txtNombre'> </p>

                </table>

            </div>
            <div class="column is-2"></div>
        </div>



        <p class="level-item"><strong> <a href="menuPrincipal.jsp">Volver</a> </strong></p>

    </body>
</html>
