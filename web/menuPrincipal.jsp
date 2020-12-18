<%--
    Author     : Marcelo Gatica Contreras
--%>
<%@page import="database.model.DBHistory"%>
<%@page import="database.dao.impl.HistoryDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-3.3.1.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.js"></script>

        <title>Menú principal</title>
    </head>
    <script>
        $(document).ready(function () {
            $('#tabla1').dataTable({
            });
        });


    </script>
    <body>
    <center>
        <nav class="navbar is-primary">


            <div><label class="title is-black is-centered">Menú principal</label></div>


        </nav>
    </center>
    <br>
    <br>
    <br>
    <br>
    <div class="columns">
        <div class="column is-3"></div>


        <div class="column is-3">
            <form action="allHistoryRec.jsp" method="POST">

                <input class="button is-primary is-rounded" type="submit" value="Mostrar Todo" />

            </form>
        </div>
    </div>



    <div class="columns">
        <div class="column is-3"></div>
        <div class="column is-5">
            <div id="divMostrarRegistro"> <!-- Se va a cargar con ajax -->
                <table id="tabla1">
                    <thead>
                        <tr><td>Nombre</td>
                            <td>Rut</td>
                            <td>Fecha</td>
                            <td>Tipo</td>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            HistoryDaoImpl hd = new HistoryDaoImpl();

                            for (DBHistory dbh : hd.getAll()) {
                        %>
                        <tr><td><%= dbh.getUserName()%></td>
                            <td><%= dbh.getUserRut()%></td>
                            <td><%= dbh.getRegisterDate()%></td>
                            <td><%= dbh.getUserType()%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>

            </div>
        </div>
        <div class="column is-3"></div>
    </div>
</body>
</html>
