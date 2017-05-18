<%-- 
    Document   : laterale
    Created on : 16-mag-2017, 12.13.38
    Author     : Martina
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="laterale">
    <div id="people">
        <h2>Persone</h2>
        <c:forEach var="user" items="${utenti}">
            <h3><a href="/Bacheca?id=${user.id}">${user.nome}</a></h3>
        </c:forEach>
    </div>
    <div id="groups">
        <h2>Gruppi</h2>
            <c:forEach var="group" items="${gruppi}">
                <h3>${group.nome}</h3>
            </c:forEach>
    </div>
</div>
