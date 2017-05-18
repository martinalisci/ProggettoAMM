<%-- 
    Document   : header
    Created on : 16-mag-2017, 12.30.11
    Author     : Martina
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header>
    <div id="title">
        <h1>Nerdbook</h1>
    </div>      
    <nav>
        <ul>
        <li <c:if test="${page=='bacheca'}">class="active"</c:if>><a href="bacheca.jsp">Bacheca</a></li>
        <li <c:if test="${page=='profilo'}">class="active"</c:if>><a href="profilo.jsp">Profilo</a></li>
        </ul>
    </nav>
    <div class="logout">
        <c:if test="${empty param.user}">
            <a href="Login?logout=1">Logout</a>
        </c:if>
    </div>
                
</header>
