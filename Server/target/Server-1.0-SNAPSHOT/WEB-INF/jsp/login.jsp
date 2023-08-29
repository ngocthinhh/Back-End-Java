<%-- 
    Document   : login
    Created on : Aug 24, 2023, 4:06:30 PM
    Author     : Ngoc Thinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${param.error != null}" >
    <div class="alert alert-danger">
        Da co loi xay ra!
    </div>
</c:if>

<c:url value="/login" var="action" />

<form method="post" action="${action}">
    <div class="form-group">
        <label for="username" >Username</label>
        <input type="text" id="username" name="name" class="form-control" />
    </div>
    
    <div class="form-group">
        <label for="password" >Password</label>
        <input type="password" id="password" name="password" class="form-control" />
    </div>
    
    <div class="form-group">
        <input type="submit" value="Dang nhap" />
    </div>
</form>
