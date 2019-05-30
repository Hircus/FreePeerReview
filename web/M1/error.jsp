<%-- 
    Document   : error
    Created on : 23-mag-2019, 19.01.36
    Author     : tobias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ACCESSO NEGATO</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Antonio Cossu">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Pagina di accesso negato">
        <link rel="stylesheet" type="text/css" href="M1/style.css" media="screen">
    </head>
    <body>

        <!-- Include header here -->
        <jsp:include page="header.jsp"/>

        <div class="row">
            <aside class="col-3"></aside>

            <main class="col-9">
                <h1>ACESSO NEGATO</h1>
                <h2>Non si hanno i permessi per entrare in questa pagina</h2>
            </main>
        </div>

        <!-- Include footer here -->
        <jsp:include page="footer.jsp"/>
    </body>
</html>
