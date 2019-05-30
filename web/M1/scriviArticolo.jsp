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
        <link rel="stylesheet" type="text/css" href="M1/style.css" media="screen">
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
                <h1>${head}</h1>

                <!--Form per inserire i dati-->

                <c:choose>
                    <c:when test="${articolo!=null}">
                        <form class="scriviArticolo" method="post" action="scriviArticolo.html?pid=${articolo.getId()}">
                        </c:when>
                        <c:when test="${articolo==null}">
                            <form class="scriviArticolo" method="post" action="scriviArticolo.html">
                            </c:when>
                        </c:choose>
                        <!--Titolo-->
                        <div>
                            <label>Titolo:</label>
                            <input type="text" title="titolo" name="titolo" value="${title}">
                        </div>

                        <!--Autori-->
                        <div class="row">
                            <label>Autori:</label>
                            <c:choose>
                                <c:when test="${articolo!=null}">
                                    <c:forEach begin="0" end="${articolo.getAutori().size()-1}" var="i">
                                        <input class="autori" type="text" title="autori" name="autori"
                                               value="${articolo.getAutori().get(i).getNome()} ${articolo.getAutori().get(i).getCognome()}">
                                    </c:forEach>
                                </c:when>
                                <c:when test="${articolo==null}">
                                    <input class="autori" type="text" title="autori" name="autori">
                                </c:when>
                            </c:choose>
                        </div>

                        <!--Categorie a checkbox-->
                        <div class="row">
                            <label>Categorie:</label>
                            <div class="check">
                                <c:choose>
                                    <c:when test="${articolo!=null}">
                                        <c:forEach items="${categorie}" var="i">
                                            <c:if test="${articolo.getCategorie().contains(i)}">
                                                <input type="checkbox" name="cat" id="${i}" checked>
                                            </c:if>
                                            <c:if test="${!(articolo.getCategorie().contains(i))}">
                                                <input type="checkbox" name="cat" id="${i}">
                                            </c:if>
                                            <label for="${i}"/>${i}
                                        </c:forEach>
                                    </c:when>
                                </c:choose>
                            </div>
                        </div>

                        <!--Immagine-->
                        <div>
                            <label>Immagine:</label>
                            <input type="text" title="immagine" name="immagine" value="${immagine}">
                        </div>

                        <!--Data-->
                        <div>
                            <label>Data:</label>
                            <input type="text" name="data" value="${data}">
                        </div>

                        <!--Testo dell'articolo-->
                        <div>
                            <label>Testo:</label>
                            <textarea maxlength="300" rows="7" cols="60" name="testo" id="testo">${testo}</textarea>
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
