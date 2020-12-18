<%--
    Author     : Marcelo Gatica Contreras
--%>
<%@page import="database.model.DBUserLogin"%>
<%@page import="database.dao.impl.UserLoginDaoImpl"%>
<%@page import="database.dao.impl.UserDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title> 
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">
    </head> 
    <body background="../src/java/imagenes/instituloImagen.jpg"> 

        <br>
        <br>
        <div class="hero-body">
            <div class="container has-text-centered">
                <h1 class="title"></h1>
                <div class="columns is-gapless">
                    <div class="column">


                    </div>

                    <script src="js/jquery-3.3.1.min.js"></script>





                </div>
                <section class="hero is-primary  is-bold">
                    <div class="hero-body">
                        <div class="container">
                            <h1 class="title is-center">Ingreso Seguro Santo Tomás</h1>
                            <h2 class="subtitle is-center">
                                Bienvenido
                            </h2>
                            <br>
                            <br>
                        </div>
                        <div class="columns">
                            <div class="column is-4">

                            </div>

                            <div class="column is-4">
                                <div id="divError" class="divError"> </div>
                                <div class="field">
                                    <div class="control has-icons-left has-icons-right">
                                        <input class="input" type="text" id="name" placeholder="Nombre de usuario:"  name="username" required="">
                                        <span class="icon is-small is-left">
                                            <i class="fas fa-user"></i>
                                        </span>
                                        <span class="icon is-small is-right">
                                            <i class="fas fa-check"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <p class="control has-icons-left">
                                        <input class="input" type="password" id="pass" placeholder="Password" name="password" required="">
                                        <span class="icon is-small is-left">
                                            <i class="fas fa-lock"></i>
                                        </span>
                                    </p>
                                </div>
                                <div class="field">
                                    <p class="control">
                                        <button class="button is-success" type="button" id="btnLogin" value="Submit" onclick="login()">
                                            Login
                                        </button>
                                    </p>
                                </div>

                            </div>
                            <style>
                                .divError {
                                    color: crimson
                                }
                            </style>
                            <script>

                                function login() {
                                    var nombre = $("#name").val();
                                    var clave = $("#pass").val();

                                    $.ajax({
                                        type: 'POST',
                                        url: 'http://localhost:8080/IngresoSantoTomasWeb/loginCheck.do',
                                        data: {nombre: nombre, clave: clave}


                                    }).done(function () {
                                        location.href = "http://localhost:8080/IngresoSantoTomasWeb/menuPrincipal.jsp";
                                    }).fail(function () {
                                        document.getElementById('divError').innerHTML += '<h1>Contraseña o usuario incorrecto</h1>';
                                    });
                                }
                            </script>
                            <div class="column is-4">
                            </div>

                        </div>

                    </div>
                </section>
            </div>
        </div>
    </body>
</html>

