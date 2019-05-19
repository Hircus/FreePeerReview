<%-- 
    Document   : scriviArticolo
    Created on : 2-mag-2019, 17.47.47
    Author     : antonio
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Scrivi un articolo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Antonio Cossu">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Pagina per scrivere articoli">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <jsp:include page="clear.jsp"/>

        <div class="row">

            <jsp:include page="nav.jsp"/>

            <!--MAIN
            PAgina in cui si possono scrivere articoli pubblici
            -->
            <main class="col-9">
                <h1>SCRIVI ARTICOLO</h1>

                <!--Form per inserire i dati-->
                <form class="scriviArticolo" method="post" action="scriviArticolo.html?pid=${articoli.get(i).getId()}">

                    <!--Titolo-->
                    <div>
                        <label>Titolo:</label>
                        <input type="text" title="titolo" name="titolo" value="${articolo.getTitolo()}">
                    </div>

                    <!--Autori-->
                    <div class="row">
                        <label>Autori:</label>
                        <c:forEach begin="0" end="${articolo.getAutori().size()-1}" var="i">
                            <input class="autori" type="text" title="autori" name="autori"
                                   value="${articolo.getAutori().get(i).getNome()} ${articolo.getAutori().get(i).getCognome()}">
                        </c:forEach>
                    </div>

                    <!--Categorie a checkbox-->
                    <div class="row">
                        <label>Categorie:</label>
                        <div class="check">
                            <input type="checkbox" title="categorie" name="cat" value="ia"/>IA
                            <input type="checkbox" title="categorie" name="cat" value="web"/>WEB
                            <input type="checkbox" title="categorie" name="cat" value="java"/>Java
                        </div>
                        <div class="check">
                            <input type="checkbox" title="categorie" name="cat" value="python"/>Python
                            <input type="checkbox" title="categorie" name="cat" value="oop"/>OOP
                            <input type="checkbox" title="categorie" name="cat" value="reti"/>Reti
                        </div>
                    </div>

                    <!--Immagine-->
                    <div>
                        <label>Immagine:</label>
                        <input type="text" title="immagine" name="immagine" value=${articolo.getImmagine()}>
                    </div>

                    <!--Data-->
                    <div>
                        <label>Data:</label>
                        <input type="text" name="data" value=${articolo.getData().toString()}>
                    </div>

                    <!--Testo dell'articolo-->
                    <div>
                        <label>Testo:</label>
                        <textarea maxlength="300" rows="7" cols="60" name="testo" id="testo">${articolo.getTesto().toString()}</textarea>
                    </div>

                    <!--Premere per proseguire-->
                    <div>
                        <button class="pageButton" name="salva" type="submit">SALVA ARTICOLO</button>    
                    </div>
                </form>
            </main>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>
