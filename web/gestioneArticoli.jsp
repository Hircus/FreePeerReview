<%-- 
    Document   : articoli
    Created on : 2-mag-2019, 17.46.21
    Author     : antonio
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <title>Articoli</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Antonio Cossu">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Pagina degli articoli">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>

        <!-- Include header here -->
        <jsp:include page="header.jsp"/>

        <!-- Include clear here -->
        <jsp:include page="clear.jsp"/>

        <div class="row">

            <!-- Include nav here -->
            <jsp:include page="nav.jsp"/>

            <!--MAIN
            Tabella in cui sono presenti gli articoli del database
            -->
            <main class="col-9">
                <h1>I MIEI ARTICOLI</h1>

                <!--Form con la tabella-->
                <form class="articoli" action="scriviArticolo.jsp" method="post">
                    <table>
                        <!--Prima riga-->
                        <tr>
                            <th>DATA</th>
                            <th>TITOLO</th>
                            <th>N. VALUTAZIONI</th>
                            <th>DECISIONE</th>
                        </tr>

                        <c:forEach begin="0" end="${maxArt}" var="i">
                            <tr class="colore1">
                                <td>${all.get(i).getData().toString()}</td>
                                <td>${all.get(i).getTitolo()}</td>    
                                <td>WIP</td>
                                <td>WIP</td>
                            </tr>
                        </c:forEach>
                        
                    </table>

                    <!--Submit per scrivere un nuovo articolo-->
                    <button type="submit" class="pageButton">SCRIVI UN ARTICOLO</button>
                </form>
            </main>
        </div>

        <!-- Include footer here -->
        <jsp:include page="footer.jsp"/>
    </body>
</html>