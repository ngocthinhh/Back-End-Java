<%-- 
    Document   : addUser
    Created on : Aug 27, 2023, 12:29:04 PM
    Author     : Ngoc Thinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Hello World!</h1>

<c:url value="/addUser" var="action" />

<form method="post" action="${action}">
    <div class="form-group">
        <label for="firstname" >Firstname</label>
        <input type="text" id="firstname" name="firstname" class="form-control" />
    </div>
    <div class="form-group">
        <label for="lastname" >Lastname</label>
        <input type="text" id="lastname" name="lastname" class="form-control" />
    </div>
    <div class="form-group">
        <label for="phone" >Phone</label>
        <input type="text" id="phone" name="phone" class="form-control" />
    </div>
    <div class="form-group">
        <label for="username" >Username</label>
        <input type="text" id="username" name="username" class="form-control" />
    </div>
    <div class="form-group">
        <label for="password" >Password</label>
        <input type="password" id="password" name="password" class="form-control" />
    </div>
    <div class="form-group">
        <label for="active" >Active</label>
        <input type="text" id="active" name="active" class="form-control" />
    </div>
    <div class="form-group">
        <label for="role" >Role</label>
        <input type="text" id="role" name="role" class="form-control" />
    </div>
    <div class="form-group">
        <label for="avatar" >Avatar</label>
        <input type="text" id="avatar" name="avatar" class="form-control" />
    </div>

    <div class="form-group">
        <input type="submit" value="Them nguoi dung" class="btn btn-danger"/>
    </div>
</form>