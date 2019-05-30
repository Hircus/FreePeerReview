<%-- 
    Document   : profilo
    Created on : 2-mag-2019, 17.47.07
    Author     : antonio
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Profilo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Antonio Cossu">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Pagina del profilo">
        <link rel="stylesheet" type="text/css" href="M1/style.css" media="screen">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <c:if test="${utente.getId()!=0}">
            <jsp:include page="clear.jsp"/>
        </c:if>


        <div class="row">
            <c:if test="${utente.getId()!=0}">
                <jsp:include page="nav.jsp"/>
            </c:if>
            
            <c:if test="${utente.getId()==0}">
                <aside class="col-3"></aside>
                </c:if>

            <!--MAIN
            Main nel quale si possono modificare i dati della registrazione
            -->
            <main class="col-9">
                <h1>${titolo}</h1>
                <form class="profilo" action="registrazione.html" method="post">
                    <div>
                        <label for="id_nome">Nome: </label>
                        <input type="text" name="nomeUtente" id="id_nome" value=${utente.getNome()}> 
                    </div>

                    <div>
                        <label for="id_cognome">Cognome: </label>
                        <input type="text" name="cognome" id="id_cognome" value=${utente.getCognome()}> 
                    </div>

                    <div>
                        <label for="id_mail">E-mail: </label>
                        <input type="text" name="mail" id="id_mail" value=${utente.getEmail()}>
                    </div>

                    <div>
                        <label for="id_foto">Foto: </label>
                        <input type="text" name="foto" id="id_foto" value=${utente.getImmagine()}>
                    </div>

                    <div>
                        <label for="id_password">Password: </label>
                        <input type="password" name="password" id="id_password" value=${utente.getPassword()}>
                    </div>

                    <div>
                        <label for="id_ente">Ente: </label>
                        <input type="text" name="ente" id="id_ente" value=${utente.getEnte()}>
                    </div>
                    <button type="submit" class="pageButton">${button1}</button>
                </form>

                <c:if test="${utente.getId()==0}">
                    <form action="logout.html" method="post">
                        <label>Non sei più interessato?</label>
                        <button type="submit" name="logout" class="pageButton reg">${button2}</button>                    
                    </form>
                </c:if>

            </main>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>
