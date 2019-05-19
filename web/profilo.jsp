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
        <title>${titoloProfilo}</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Antonio Cossu">
        <meta name="keywords" content="FPW, Progetto, HTML, CSS, Java">
        <meta name="description" content="Pagina del profilo">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <jsp:include page="clear.jsp"/>

        <div class="row">

            <jsp:include page="nav.jsp"/>

            <!--MAIN
            Main nel quale si possono modificare i dati della registrazione
            -->
            <main class="col-9" id="profilo">
                <h1>${titoloProfilo}</h1>
                <form class="profilo" action="profilo.jsp" method="post">
                    <div>
                        <label for="id_nome">Nome: </label>
                        <input type="text" name="nomeUtente" id="id_nome" value= ${autore.getNome()} />
                    </div>

                    <div>
                        <label for="id_cognome">Cognome: </label>
                        <input type="text" name="cognome" id="id_cognome" value= ${autore.getCognome()} />
                    </div>

                    <div>
                        <label for="id_mail">E-mail: </label>
                        <input type="text" name="mail" id="id_mail" value= ${autore.getEmail()} />
                    </div>

                    <div>
                        <label for="id_foto">Foto: </label>
                        <input type="text" name="foto" id="id_foto" value= ${autore.getImmagine()}/>
                    </div>

                    <div>
                        <label for="id_password">Password: </label>
                        <input type="password" name="password" id="id_password" value= ${autore.getPassword()} />
                    </div>

                    <div>
                        <label for="id_ente">Ente: </label>
                        <input type="text" name="ente" id="id_ente" value=${autore.getEnte()}/>
                    </div>
                    <button type="submit" class="pageButton">${button1}</button>
                </form>

                <div>
                    <form action="login.jsp" method="post">
                        <label>Non sei più interessato?</label>
                        <br/>
                        <button type="submit" class="pageButton">${button2}</button>                    
                    </form>
                </div>

            </main>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>
