<%-- 
    Document   : header
    Created on : Aug 23, 2023, 12:13:47 AM
    Author     : Ngoc Thinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/" var="action" />
<c:url value="/login" var="login" />

<nav class="navbar navbar-expand-sm navbar-success bg-success">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <a class="navbar-brand" href="${action}">Trang chủ</a>
            
            <li class="nav-item">
                <a class="nav-link" href="${login}">Đăng nhập</a>
            </li>
        </ul>
    </div>
</nav>
