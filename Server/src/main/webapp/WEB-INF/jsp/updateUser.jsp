<%-- 
    Document   : updateUser
    Created on : Aug 27, 2023, 11:34:16 PM
    Author     : Ngoc Thinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Hello World!</h1>

<c:url value="/update/${user.id}" var="action" />

<form:form method="post" action="${action}" modelAttribute="user">
    <form:hidden path="id" />
    <div class="form-group">
        <label for="firstname" >Firstname</label>
        <form:input type="text" class="form-control" path="firstname" id="firstname"/>
    </div>
    <div class="form-group">
        <label for="lastname" >Lastname</label>
        <form:input type="text" class="form-control" path="lastname" id="lastname"/>
    </div>
    <div class="form-group">
        <label for="phone" >Phone</label>
        <form:input type="text" class="form-control" path="phone" id="phone"/>
    </div>
    <div class="form-group">
        <label for="username" >Username</label>
        <form:input type="text" class="form-control" path="username" id="username"/>
    </div>
    <div class="form-group">
        <label for="password" >Password</label>
        <form:input type="password" class="form-control" path="password" id="password"/>
    </div>
    <div class="form-group">
        <label for="active" >Active</label>
        <form:input type="text" class="form-control" path="active" id="active"/>
    </div>
    <div class="form-group">
        <label for="role" >Role</label>
        <form:input type="text" class="form-control" path="role" id="role"/>
    </div>
    <div class="form-group">
        <label for="avatar" >Avatar</label>
        <form:input type="text" class="form-control" path="avatar" id="avatar"/>
    </div>
        
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${user.id == null}">Thêm sản phẩm</c:when>
                <c:otherwise>Cập nhật sản phẩm</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>