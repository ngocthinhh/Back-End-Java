<%-- 
    Document   : headerRole
    Created on : Sep 8, 2023, 10:22:40 PM
    Author     : Ngoc Thinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/homepageAdmin" var="action" />
<c:url value="/homepageEmployee" var="action2" />
<c:url value="/listUser" var="user" />
<c:url value="/listRoute" var="route" />
<c:url value="/listTrip" var="trip" />
<c:url value="/listReservation" var="reservation" />
<c:url value="/listPayment" var="payment" />
<c:url value="/listFeedback" var="feedback" />
<c:url value="/login" var="login" />

<% String role = (String) application.getAttribute("role"); %>
<% String fullname = (String) application.getAttribute("fullname"); %>

<nav class="navbar navbar-expand-sm navbar-success bg-success">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <c:choose>
                <c:when test="${role eq 'ADMIN'}">
                    <a class="navbar-brand" href="${action}">Trang chủ</a>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="${user}">Người dùng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${route}">Tuyến đi</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${trip}">Chuyến đi</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${reservation}">Ghế đặt</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${payment}">Lịch sử thanh toán</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${feedback}">Phản hồi</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <a class="navbar-brand" href="${action2}">Trang chủ</a>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="${route}">Tuyến đi</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${trip}">Chuyến đi</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${reservation}">Ghế đặt</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${payment}">Lịch sử thanh toán</a>
                    </li>
                </c:otherwise>
            </c:choose>
            
            <li class="nav-item">
                <a class="nav-link"">${fullname}</a>
            </li>
            <li class="nav-item">
                <a class="nav-link""> | </a>
            </li>   
            <li class="nav-item">
                <a class="nav-link" href="${login}">Đăng xuất</a>
            </li>
        </ul>
    </div>
</nav>
