<%-- 
    Document   : trip
    Created on : Sep 7, 2023, 11:15:10 PM
    Author     : Ngoc Thinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/trip" var="action" />

<form:form method="post" action="${action}" modelAttribute="trip">
    <form:hidden path="idTrip" />
    <div class="form-group">
        <label for="departureTimeTrip" >Thời gian khởi hành</label>
        <form:input type="text" class="form-control" path="departureTimeTrip" id="departureTimeTrip"/>
    </div>
    <div class="form-group">
        <label for="priceTrip" >Đơn giá</label>
        <form:input type="text" class="form-control" path="priceTrip" id="priceTrip"/>
    </div>
    <div class="form-group">
        <label for="numberSeatsTrip" >Số lượng ghế</label>
        <form:input type="number" class="form-control" path="numberSeatsTrip" id="numberSeatsTrip"/>
    </div>
    <div class="form-group">
        <label for="idRouteTrip" >Mã tuyến đi</label>
        <form:select path="idRouteTrip" class="form-control" id="idRouteTrip">
            <c:forEach var="r" items="${routes}">
                <form:option value="${r.idRoute}">${r.idRoute}</form:option>
            </c:forEach>
        </form:select>
    </div>
    
    <div class="form-group">
        <label for="idUserTrip" >Mã tài xế</label>
        <form:select path="idUserTrip" class="form-control" id="idUserTrip">
            <c:forEach var="u" items="${users}">
                <form:option value="${u.idUser}">${u.idUser}</form:option>
            </c:forEach>
        </form:select>
    </div>

    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${trip.idTrip == -1}">Thêm người mới</c:when>
                <c:otherwise>Cập nhật người dùng</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
