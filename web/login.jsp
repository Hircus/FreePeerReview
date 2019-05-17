<%-- 
    Document   : login
    Created on : 2-mag-2019, 17.46.52
    Author     : antonio
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Antonio Cossu">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Pagina di Login">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="row">


            <aside class="col-3"></aside>
            <!--MAIN
            Form per fare il login al sito, con e-mail e password
            -->
            <main class="col-8" id="login">
                <h1>Login</h1>
                <form class="login" action="login.html" method="post">
                    <div>
                        <label for="mail">Email</label>
                        <input type="text" name="email" id="mail"/>
                    </div>
                    <div>
                        <label for="id_pass">Password</label>
                        <input type="password" name="password" id="id_pass"/>
                    </div>
                    <button type="submit" name="login" class="pageButton">ACCEDI</button>
                </form> 
            </main>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>
