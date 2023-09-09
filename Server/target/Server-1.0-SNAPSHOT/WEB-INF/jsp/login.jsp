<%-- 
    Document   : login
    Created on : Sep 8, 2023, 9:20:41 PM
    Author     : Ngoc Thinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/login" var="action" />

<form:form method="post" action="${action}" modelAttribute="user" enctype="multipart/form-data">
    <form:hidden path="idUser" />
    <div class="form-group">
        <label for="usernameUser" >Tài khoản</label>
        <form:input type="text" class="form-control" path="usernameUser" id="usernameUser"/>
    </div>
    <div class="form-group">
        <label for="passwordUser" >Mật khẩu</label>
        <form:input type="password" class="form-control" path="passwordUser" id="passwordUser"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            Đăng nhập
        </button>
    </div>
</form:form>

