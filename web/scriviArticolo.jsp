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
            <main class="col-8">
                <h1>SCRIVI ARTICOLO</h1>

                <!--Form per inserire i dati-->
                <form class="scriviArticolo">

                    <!--Titolo-->
                    <div class="row">
                        <label>Titolo:</label>
                        <input type="text" title="titolo" value="Esempio: Come usare i CSS">
                    </div>

                    <!--Autori-->
                    <div class="row">
                        <label>Autori:</label>
                        <input type="text" title="autori" value="Esempio: Cossu Antonio">
                    </div>

                    <!--Categorie a checkbox-->
                    <div class="row">
                        <label>Categorie:</label>
                        <div class="check">
                            <input type="checkbox" title="categorie" id="cat1">
                            <label for="cat1">IA</label>
                            <input type="checkbox" title="categorie" id="cat2">
                            <label for="cat2">WEB</label>
                            <input type="checkbox" title="categorie" id="cat3">
                            <label for="cat3">Java</label>
                        </div>
                        <div class="check">
                            <input type="checkbox" title="categorie" id="cat4">
                            <label for="cat4">Python</label>
                            <input type="checkbox" title="categorie" id="cat5">
                            <label for="cat5">OOP</label>
                            <input type="checkbox" title="categorie" id="cat6">
                            <label for="cat6">Calcolatori</label>
                        </div>
                    </div>

                    <!--Immagine-->
                    <div class="row">
                        <div>
                            <label>Immagine:</label>
                            <input type="file" title="immagine">
                        </div>
                    </div>

                    <!--Foto profilo-->
                    <div class="row">
                        <div>
                            <label>Data:</label>
                            <input type="date">
                        </div>
                    </div>

                    <!--Testo dell'articolo-->
                    <div class="row">
                        <div>
                            <label>Testo:</label>
                            <textarea maxlength="300" rows="7" cols="60" name="testo" id="testo"></textarea>
                        </div>
                    </div>

                    <!--Premere per proseguire-->
                    <div class="row">
                        <div>
                            <button class="pageButton" type="submit">SALVA ARTICOLO</button>    
                        </div>
                    </div>
                </form>
            </main>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>
