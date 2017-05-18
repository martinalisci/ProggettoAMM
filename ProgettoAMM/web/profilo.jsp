<%-- 
    Document   : profilo
    Created on : 16-mag-2017, 12.12.36
    Author     : Martina
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdbook</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Martina Lisci">
	<meta name="keywords" content="cerca i tuoi amici">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        
        <c:set var="page" value="Profilo" scope="request"/>
        <jsp:include page="header.jsp"/> 
        
        <div id="divBody">
            <c:set var="page" value="Profilo" scope="request"/>
            <jsp:include page="laterale.jsp"/>
            <div id="formProfile">
                <form action="Profilo" method="post">
                    <div id="profile">
                        <div>
                            <label class="labelProf" for="surname">Cognome</label>
                            <input class="labelProf" type="text" name="surname" value="Cognome" id="surname">
                            
                        </div>
                        
                        <div>
                            <label class="labelProf" for="name">Nome</label>
                            <input class="labelProf" type="text" name="name" value="Nome" id="name">
                            
                        </div>
                        
                        <div>
                            <label class="labelProf" for="sentence">Frase di presentazione</label>
                            <textarea class="labelProf" name="sentence" id="sentence">Inserisci la tua frase</textarea>
                            
                        </div>
                        
                        <div>
                            <label class="labelProf" for="image">Url dell'immagine del profilo</label>
                            <input class="labelProf" type="text" name="image" value="URL" id="image">
                            
                        </div>
                        
                        <div>
                            <label class="labelProf" for="date">Data di nascita</label>
                            <input class="labelProf" type="date" name="date" id="date">
                            
                        </div>
                        
                        <div>
                            <label class="labelProf" for="password">Password</label>
                            <input class="labelProf" type="password" name="password" value="password" id="password">
                           
                        </div>
                        
                        <div>
                            <label class="labelProf" for="password2">Conferma Password</label>
                            <input class="labelProf" type="password" name="password2" value="Conferma password" id="password2">
                            
                        </div>
                        
                        <div>
                            <button type="submit">Aggiorna</button>
                        </div>
                    </div>
                    <c:if test="${inviato == true}">
                        <h3>I dati sono stati inviati.</h3>
                        <Nome : <%= request.getParameter("name")%>
                        <p>Cognome : <%= request.getParameter("surname")%></p>
                        <p>Frase di presentazione : <%= request.getParameter("sentence")%></p>
                        <p>Immagine profilo : <%= request.getParameter("image")%></p>
                        <p>Data di nascita : <%= request.getParameter("date")%></p>
                        <p>Password : <%= request.getParameter("password")%></p>
                    </c:if>
                </form>  
            </div>    
        </div>
    </body>
</html>
