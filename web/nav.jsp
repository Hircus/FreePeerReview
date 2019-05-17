<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--SIDEBAR
                Contiene il nav con i link per navigare nelle pagine 
    -->
    <aside class="col-3">
        <img title="avatar" src="img/avatar.png" alt="Immagine Utente" height="100px" width="100px"/>
        <div id="utente_nav">Ciao ${autore.getNome()}!</div>

        <form action="logout.html" method="post" class="logout_nav">
            <button class="logout" name="logout" type="submit">LOGOUT</button>
        </form>
        
        <h2>I tuoi articoli:</h2>
        <ul class="nav">
            <c:forEach begin="0" end="1" var="i">
                <div>${articoli.get(i).getTitolo()}</div>
            </c:forEach>
        </ul>
    </aside>

</html>
