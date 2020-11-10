<%-- 
    Document   : allHistoryRec
    Created on : 09-11-2020, 17:39:48
    Author     : marce
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%  FPConfig cfig1 = new FPConfig(true);
            Conexion con = new Conexion(cfig1.getDbName(), cfig1.getDbHost(), cfig1.getDbUser(), cfig1.getDbPasswd());
            HistoryDaoImpl daoImpl = new HistoryDaoImpl(con);
            List<DBHistory> dbhs = new ArrayList<>();
            dbhs = daoImpl.getAll(); %>
        



        <ol>
            <%for (DBHistory record : dbhs) {
            %> <li>Nombre: <% record.getUserName(); %></li> <%
            %> <li>Rut: <% record.getUserRut(); %></li> <%
            %> <li>Fecha Registro: <% record.getRegisterDate(); %></li> 
            <a>--------------------------------------------------</a>
        </ol>
        <% }%>



        <p class="level-item"><strong> <a href="index.jsp">Volver</a> </strong></p>

    </body>
</html>
