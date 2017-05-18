<%-- 
    Document   : Login
    Created on : 2-mag-2017, 11.38.49
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
        
        <header>
            <div id="title" class="titoloLog">
                <h1>Login</h1>
            </div>
        </header>
        <div id="divBody">
            <div id="titleLog">
                <h2>Nerdbook</h2>
            </div>
            <div id="formLogin">  
                <c:if test="${invalidData == true}">
                    <div id="invalidDataWarning">I dati inseriti non sono corretti</div>
                </c:if>
                    
                <c:if test="${nonAutenticato == true}">
                    <div id="nonAutenticato">L'utente non è autenticato</div>
                </c:if>
                
                <form action="Login" method="post">
                     <div id="contentLog">
                         <div id="nomeLog">
                              <label class="labelLog" for="userName">Nome Utente</label>
                              <input class="labelLog" type="text" name="username" value="username" id="userName">
                        </div>
                        <div id="passLog">
                            <label class="labelLog" for="password">Password</label>
                            <input class="labelLog" type="password" name="password" value="password" id="password">
                        </div>
                         <button  class="labelLog" type="submit">Accedi</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>

