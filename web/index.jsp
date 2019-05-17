<%-- 
    Document   : index
    Created on : 2-mag-2019, 17.56.27
    Author     : antonio
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--
        Gestione dei metadati del sito e del link ai css
        -->
        <title>HOME</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Antonio Cossu">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Home del sito di Free Peer Review">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <!-- Include header here -->
        <jsp:include page="header.jsp"/>

        <div class="row">            
            <!--MAIN
            Si può decidere se accedere oppure registrarsi
            -->
            <main class="col-12" id="index">
                <h1 id="benv">BENVENUTO!</h1>

                <div class="row">Hai già un account?
                    <form action="login.jsp" method="post">
                        <button class="pageButton" type="submit">ACCEDI</button>
                    </form>
                </div>

                <div class="row">Oppure vuoi registrarti?
                    <form action="registrazione.jsp" method="post">
                        <button class="pageButton" type="submit">REGISTRAMI</button>
                    </form>
                </div>
            </main>

        </div>
        <!-- Include footer here -->
        <jsp:include page="footer.jsp"/>
    </body>
</html>
