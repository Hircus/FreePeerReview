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
        <link rel="stylesheet" type="text/css" href="M1/style.css" media="screen">
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <jsp:include page="navbar.jsp"/>

        <div class="row">

            <jsp:include page="sidebar.jsp"/>

            <!--MAIN
            Valutazione di un articolo nel database
            -->
            <main class="col-9">
                <!--Titolo dell'articolo-->
                <h1>${art.getTitolo()}</h1>

                <!--Autori dell'articolo-->                
                <h2>Autori:</h2>
                <c:forEach begin="0" var="i" end="${maxAut}">
                    <div>${art.getAutori().get(i).getNome()}</div>
                </c:forEach>

                <!--Immagine descrittiva dell'argomento-->
                <br/>
                <img src="img/article.jpeg" title="fotoarticolo" alt="Immagine illustrativa">

                <!--Categorie descrittive dell'articolo in questione-->
                <h2>Categorie:</h2>
                <div>IA</div>

                <!--Data della scrittura-->
                <h2>Data: </h2>
                <div>${art.getData()}</div>

                <!--Testo-->
                <h2>Testo: </h2>
                <p>${art.getTesto()}</p>
                <hr>

                <!--Form per il voto tra 1 stella e 5 stelle-->
                <h2 id="voto">Valutazione:</h2>
                <div>
                    <select name="voto">
                        <c:forEach begin="1" end="5" var="i">
                            <option value="${i}"> ${i} STELLA/E</option>
                        </c:forEach>
                    </select>
                </div>

                <!--Form per i commenti, ci sono due box, una per gli autori mentre l'altra è per gli organizzatori-->
                <form>
                    <div>
                        <label for=commAutori>Commenti per gli autori:</label>
                    </div>
                    <textarea maxlength="300" rows="7" cols="80" id="commAutori">${val.getCommAut()}</textarea>
                    <div>
                        <label for=commOrg>Commenti per gli organizzatori:</label>
                    </div> 
                    <textarea maxlength="300" rows="7" cols="80" id="commOrg">${val.getCommOrg()}</textarea>
                </form>
                <br/>
            </main>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>
