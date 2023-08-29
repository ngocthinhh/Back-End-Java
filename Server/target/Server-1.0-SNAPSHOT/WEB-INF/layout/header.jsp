<%-- 
    Document   : header
    Created on : Aug 23, 2023, 12:13:47 AM
    Author     : Ngoc Thinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm navbar-success bg-success">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/" />">Trang chu</a>
            </li>
            
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/login" />">Dang nhap</a>
                </li>
            </c:if>
                
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/" />">${pageContext.request.userPrincipal.name}</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
