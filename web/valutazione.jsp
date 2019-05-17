<%-- 
    Document   : valutazione
    Created on : 2-mag-2019, 17.48.03
    Author     : antonio
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Valutazioni</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Antonio Cossu">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Pagina delle valutazioni">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <jsp:include page="clear.jsp"/>

        <div class="row">

            <jsp:include page="nav.jsp"/>

            <!--MAIN
            Valutazione di un articolo nel database
            -->
            <main class="col-8">
                <!--Titolo dell'articolo-->
                <h1 class="row">La verità su machine learning e deep learning</h1>

                <!--Autori dell'articolo-->
                <h2 class="row">Autori:</h2>
                <div>Cossu Antonio</div>

                <!--Immagine descrittiva dell'argomento-->
                <img class="row" src="img/article.jpeg" title="fotoarticolo" alt="Immagine illustrativa">

                <!--Categorie descrittive dell'articolo in questione-->
                <h2 class="row">Categorie:</h2>
                <div>IA</div>

                <!--Data della scrittura-->
                <h2>Data: </h2>
                <div>05/04/2019</div>

                <!--Testo in sè-->
                <p>Ultimamente l'opinione pubblica sulle intelligenze artificiali sta cambiando: in pratica non sono gli strumenti che porteranno all'estinzione l'umanità; più semplicemente le IA attualmente sono programmate per imparare a compiere cose semplicissime e per fare questo ci vuole anche molto lavoro.</p>
                <hr>

                <!--Form per il voto tra 1 stella e 5 stelle-->
                <h2 class="row" id="voto">Valutazione:</h2>
                <div>
                    <select name="voto">
                        <option value="1">1 STELLA</option>
                        <option value="2">2 STELLE</option>
                        <option value="1">3 STELLE</option>
                        <option value="1">4 STELLE</option>
                        <option value="1">5 STELLE</option>
                    </select>
                </div>

                <!--Form per i commenti, ci sono due box, una per gli autori mentre l'altra è per gli organizzatori-->
                <form>
                    <div>
                        <label for=commAutori>Commenti per gli autori:</label>
                    </div>
                    <textarea maxlength="300" rows="7" cols="80" id="commAutori"></textarea>
                    <div>
                        <label for=commOrg>Commenti per gli organizzatori:</label>
                    </div> 
                    <textarea maxlength="300" rows="7" cols="80" id="commOrg"></textarea>
                </form>
                <br/>
            </main>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>
