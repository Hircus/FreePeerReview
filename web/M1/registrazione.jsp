<%-- 
    Document   : registrazione
    Created on : 2-mag-2019, 17.47.24
    Author     : antonio
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registrazione</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Antonio Cossu">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Pagina di Registrazione">
        <link rel="stylesheet" type="text/css" href="M1/style.css" media="screen">
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <jsp:include page="navbar.jsp"/>

        <div class="row">

            <jsp:include page="sidebar.jsp"/>

            <!--MAIN
            Main con il form per registrarsi, i dati in ordine sono:
            --> 
            <main class="col-9">
                <h1>Registrazione</h1>
                <form class="registrazione" action="registrazione.html" method="post">

                    <!--Nome-->
                    <div>
                        <label for="id_nome">Nome: </label>
                        <input type="text" name="nome" id="id_nome" value="Antonio"/>
                    </div>

                    <!--Cognome-->
                    <div>
                        <label for="id_cognome">Cognome: </label>
                        <input type="text" name="cognome" id="id_cognome" value="Cossu"/>
                    </div>

                    <!--E-mail-->
                    <div>
                        <label for="id_mail">E-mail: </label>
                        <input type="text" name="email" id="id_mail" value="cossu@mail.com"/>
                    </div>

                    <!--Foto-->
                    <div>
                        <label for="id_foto">Foto:</label>
                        <input type="text" name="foto" id="id_foto" value="foto.png"/>
                    </div>

                    <!--Password-->
                    <div>
                        <label for="id_password">Password: </label>
                        <input type="password" name="password" id="id_password" value="ciao"/>
                    </div>

                    <!--Ente per cui si lavora-->
                    <div>
                        <label for="id_ente">Ente: </label>
                        <input type="text" name="ente" id="id_ente" value="Unica"/>
                    </div>

                    <!--Submit button per registrarsi-->
                    <button type="submit" name="check" class="pageButton">Registrati</button>
                </form>

                <form action="logout.html" method="post">
                    <label>Non sei più interessato?</label>
                    <button type="submit" name="logout" class="pageButton reg">VAI AL LOGIN</button>                    
                </form>

            </main>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>
