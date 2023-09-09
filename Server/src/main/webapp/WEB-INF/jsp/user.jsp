<%-- 
    Document   : user
    Created on : Aug 23, 2023, 9:59:54 PM
    Author     : Ngoc Thinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/user" var="action" />

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
    <div class="form-group">
        <label for="roleUser" >Họ tên</label>
        <form:input type="text" class="form-control" path="fullNameUser" id="roleUser"/>
    </div>
    <div class="form-group">
        <label for="roleUser" >Số điện thoại</label>
        <form:input type="text" class="form-control" path="phoneNumberUser" id="roleUser"/>
    </div>
    <div class="form-group">
        <label for="roleUser" >Quyền</label>
        <form:select path="roleUser" class="form-control" id="roleUser">
            <form:option value="ADMIN">ADMIN</form:option>
            <form:option value="EMPLOYEE">EMPLOYEE</form:option>
            <form:option value="DRIVER">DRIVER</form:option>
            <form:option value="CUSTOMER">CUSTOMER</form:option>
        </form:select>
    </div>
    <div class="form-group">
        <label for="avatarUser" >Ảnh đại diện</label>
        <form:input type="text" class="form-control" path="avatarUser" id="avatarUser"/>
    </div>
    <!--<div class="form-group">-->
        <!--<label for="image">Chọn ảnh</label>-->
        <%--<form:input type="file" id="image" path="file" cssClass="form-control" />--%>
    <!--</div>-->

    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${user.idUser == -1}">Thêm người mới</c:when>
                <c:otherwise>Cập nhật người dùng</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>