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
        <c:set var="page" value="Bacheca" scope="request"/>
        <jsp:include page="header.jsp"/> 
        
        <div id="divBody">
            <div id="divHome">
                <c:set var="page" value="Bacheca" scope="request"/>
                <jsp:include page="laterale.jsp"/>
                
               <c:choose>
                    <c:when test="${empty newpost}">
                        <div id="formCrea">
                            <form action="Bacheca" method="post">
                                <div id="postType">
                                    <div>
                                        <label class="labelCrea" for="textType">Post di Testo</label>
                                        <input type="radio" name="postType" value="textType" id="textType" checked="checked">
                                    </div>
                                    <div>
                                        <label class="labelCrea" for="imgType">Post con Foto</label>
                                        <input type="radio" name="postType" value="imgType" id="imgType">
                                    </div>
                                </div>
                                <div id="postContent">
                                    <div>
                                        <label class="labelCrea" for="textPost">Testo</label>
                                        <textarea name="textPost" id="textPost"></textarea>
                                    </div>
                                    <div>
                                        <label class="labelCrea" for="imgPost">File d'immagine</label>
                                        <input type="file" name="imgPost" id="imgPost">
                                    </div>
                                </div>
                                <button type="submit" name="thereIsPost" value="needConfirm">Invia</button>
                            </form>
                        </div>
                    </c:when>
                    <c:otherwise>
                    
                        <div id="posts">

                            <c:forEach var="post" items="${posts}">
                                <div class="headProf">
                                    <img class="profilePic" alt="foto utente" src="${user.urlFotoProfilo}">
                                    <h3 class="user">${user.nome}</h3>
                                </div>
                                <div class ="bodyProf">
                                    <c:if test="${post.postType == 'TEXT'}">
                                        <p>${post.contenuto}</p>
                                    </c:if>
                                    <c:if test="${post.postType == 'IMAGE'}">
                                        <img alt="Post con foto" src="${post.contenuto}">
                                    </c:if>
                                </div> 
                            </c:forEach>    
                        </div>
                    </c:otherwise>
                </c:choose>
                
                <div id="posts">
                  
                    <c:forEach var="post" items="${posts}">
                        <div class="headProf">
                            <img class="profilePic" alt="foto utente src="${user.urlFotoProfilo}">
                            <h3 class="user">${user.nome}</h3>
                        </div>
                        <div class ="bodyProf">
                            <c:if test="${post.postType == 'TEXT'}">
                                <p>${post.contenuto}</p>
                            </c:if>
                            <c:if test="${post.postType == 'IMAGE'}">
                                <img alt="Post con foto" src="${post.contenuto}">
                            </c:if>
                        </div> 
                    </c:forEach>    
                </div>
            </div> 
        </div>
    </body>
</html>
