<%-- 
    Document   : clear
    Created on : 2-mag-2019, 18.17.35
    Author     : antonio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:if test="${utente !=null}">
        <c:choose>
            <c:when test="${utente.getTipo() != false}">
                <div class="col-12" id="clear">
                    <nav class="link">
                        <form action="registrazione.html" method="post" class="topform">
                            <button class="topButton" type="submit">PROFILO</button>
                        </form>
                        <form action="valutazione.html" method="post" class="topform">
                            <button class="topButton" type="submit">VALUTAZIONE</button>
                        </form>
                        <form action="articoli.html" method="post" class="topform">
                            <button class="topButton" name="articoli" type="submit">ARTICOLI</button>
                        </form>
                    </nav>
                </div>
            </c:when>
            <c:otherwise>
                <div class="col-12" id="clear">
                    <nav class="link">
                        <form action="gestione.html" method="post" class="topform">
                            <button class="topButton" type="submit">GESTIONE</button>
                        </form>
                    </nav>
                </div>
            </c:otherwise>
        </c:choose>
    </c:if>

</html>
