<%-- 
    Document   : main
    Created on : 05-11-2020, 20:41:14
    Author     : marce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menú principal</h1>
        <nav>
            <!-- Left side -->
            <div>
                <div>
                    <p><strong>x</strong> registros</p>
                </div>
                <div>
                    <div>
                        <p>
                            <input class="input" type="text" placeholder="Nombre de la persona">
                        </p>
                        <p class="control">
                            <button class="button">
                                Filtrar registros
                            </button>
                        </p>
                    </div>
                </div>
            </div>

            <!-- Right side -->
            <div class="level-right">
                <p class="level-item"><strong> <a href="allHistoryRec.jsp">Mostrar Todo</a> </strong></p>
                <p class="level-item"><a>Registrados ultimamente</a></p>
            </div>
        </nav>
    </body>
</html>
