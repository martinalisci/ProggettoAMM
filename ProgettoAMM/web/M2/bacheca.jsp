<%-- 
    Document   : bacheca
    Created on : 2-mag-2017, 11.41.08
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
 
         <!--header contenente in titolo della pagina-->
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="header.jsp"/>

        
        <div id="divBody">
            <div id="divHome">
                
                <div id="laterale">
                    <div id="people">
                        <h2>Persone</h2>
                        <h3>Pinco Pallino</h3>
                        <h3>Riccardo Rossi</h3>
                        <h3>Mario Bianchi</h3>
                    </div>
                    <div id="groups">
                        <h2>Gruppi</h2>
                        <h3>Mongolfieristi</h3>
                        <h3>Ritardatari</h3>
                    </div>
                    
                    
                </div>
                
                
                <div id="posts">
                  
                    <c:forEach var="post" items="${posts}">
                        <div class="headProf">
                            <img class="profilePic" alt="foto utente src="${user.urlFotoProfilo}">
                            <h3 class="user">${user.nome}</h3>
                        </div>
                        <div class ="bodyProf">
                            <c:if test="${post.postType == 'TEXT'}">
                                <p>${post.content}</p>
                            </c:if>
                            <c:if test="${post.postType == 'IMAGE'}">
                                <img alt="Post con foto" src="${post.content}">
                            </c:if>
                        </div> 
                    </c:forEach>    
                </div>
            </div> 
        </div>
    </body>
</html>
