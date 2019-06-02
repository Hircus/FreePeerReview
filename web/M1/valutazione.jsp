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
                <h1>ARTICOLI DA VALUTARE</h1>
                <c:if test="${articoli.size()==0}">
                    <h1>Non sono presenti articoli</h1>
                </c:if>

                <c:choose>
                    <c:when test="${valArticolo==null}">
                        <table style="width: 60%">
                            <tr>
                                <th>TITOLO</th>
                                <th>DATA</th>
                            </tr>
                            <c:forEach begin="0" end="${valArticoli.size()-1}" var="i">
                                <tr class="colore1">
                                    <td>
                                        <a href="valutazione.html?pid=${valArticoli.get(i).getId()}">${valArticoli.get(i).getTitolo()}</a>
                                    </td>
                                    <td>${valArticoli.get(i).getData().toString()}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>
                    <c:when test="${valArticolo!=null}">
                        <!--Titolo dell'articolo-->
                        <h1>${valArticolo.getTitolo()}</h1>

                        <!--Autori dell'articolo-->                
                        <h2>Autori:</h2>
                        <c:forEach begin="0" var="i" end="${valArticolo.getAutori().size()-1}">
                            <div>${valArticolo.getAutori().get(i).getNome()}</div>
                        </c:forEach>

                        <!--Immagine descrittiva dell'argomento-->
                        <br/>
                        <img src="img/article.png" title="fotoarticolo" alt="Immagine illustrativa" height="300" width="500">

                        <!--Categorie descrittive dell'articolo in questione-->
                        <h2>Categorie:</h2>
                        <div>${valArticolo.getCategorie()}</div>

                        <!--Data della scrittura-->
                        <h2>Data: </h2>
                        <div>${valArticolo.getData()}</div>

                        <!--Testo-->
                        <h2>Testo: </h2>
                        <p>${valArticolo.getTesto()}</p>
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
                            <textarea maxlength="100" rows="7" cols="80" id="commAutori">${val.getCommAut()}</textarea>
                            <div>
                                <label for=commOrg>Commenti per gli organizzatori:</label>
                            </div> 
                            <textarea maxlength="100" rows="7" cols="80" id="commOrg">${val.getCommOrg()}</textarea>
                        </form>
                        <br/> 
                    </c:when>
                </c:choose>
            </main>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>
