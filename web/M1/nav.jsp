<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--SIDEBAR
                Contiene il nav con i link per navigare nelle pagine 
    -->
    <aside class="col-3">
        <c:if test="${utente !=null}">
            <img title="avatar" src="img/avatar.png" alt="Immagine Utente" height="100px" width="100px"/>
            <div id="utente_nav">Ciao ${utente.getNome()}!</div>

            <form action="logout.html" method="post" class="logout_nav">
                <button class="logout" name="logout" type="submit">LOGOUT</button>
            </form>

            <c:if test="${utente.getTipo()}">
                <ul class="nav">
                    <c:if test="${articoli.size()!=0}">
                        <h1>Non sono presenti articoli</h1>
                    </c:if>
                    <c:if test="${articoli.size()!=0}">
                        <h2>I tuoi articoli:</h2>
                        <c:forEach begin="0" end="${maxArtUtente}" var="i">
                            <li>
                                <a href="scriviArticolo.html?pid=${articoli.get(i).getId()}">
                                    ${articoli.get(i).getTitolo()}
                                </a>
                            </li>
                        </c:forEach>
                    </c:if>
                </ul>
            </c:if>
        </c:if>
    </aside>

</html>
