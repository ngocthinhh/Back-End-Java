<%-- 
    Document   : route
    Created on : Sep 7, 2023, 1:44:46 PM
    Author     : Ngoc Thinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/route" var="action" />

<form:form method="post" action="${action}" modelAttribute="route">
    <div class="form-group">
        <label for="idRoute" >Mã tuyến đi</label>
        <form:input type="text" class="form-control" path="idRoute" id="idRoute"/>
    </div>
    <div class="form-group">
        <label for="nameRoute" >Tên tuyến đi</label>
        <form:input type="text" class="form-control" path="nameRoute" id="nameRoute"/>
    </div>
    <div class="form-group">
        <label for="startingPointRoute" >Điểm đi</label>
        <form:input type="text" class="form-control" path="startingPointRoute" id="startingPointRoute"/>
    </div>
    <div class="form-group">
        <label for="destinationRoute" >Điểm đến</label>
        <form:input type="text" class="form-control" path="destinationRoute" id="destinationRoute"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${route.idRoute eq '-1'}">Thêm tuyến mới</c:when>
                <c:otherwise>Cập nhật tuyến</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>