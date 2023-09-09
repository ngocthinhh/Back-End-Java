<%-- 
    Document   : headerEmployee
    Created on : Sep 8, 2023, 10:41:29 PM
    Author     : Ngoc Thinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/homepageEmployee" var="action" />
<c:url value="/listRouteEm" var="route" />
<c:url value="/listTripEm" var="trip" />
<c:url value="/listReservationEm" var="reservation" />
<c:url value="/listPaymentEm" var="payment" />
<c:url value="/loginEm" var="login" />

<nav class="navbar navbar-expand-sm navbar-success bg-success">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <a class="navbar-brand" href="${action}">Trang chủ</a>

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
                <a class="nav-link" href="${login}">Đăng xuất</a>
            </li>
        </ul>
    </div>
</nav>