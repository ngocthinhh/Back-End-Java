<%-- 
    Document   : index
    Created on : Aug 22, 2023, 10:11:02 PM
    Author     : Ngoc Thinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul>
    <c:forEach var="u" items="${users}">
        <li>${u.id}</li>
        <li>${u.firstname}</li>
        <li>${u.lastname}</li>
        <li>${u.phone}</li>
        <li>${u.username}</li>
        <li>${u.password}</li>
        <li>${u.active}</li>
        <li>${u.role}</li>
        <li>
            <img src="${u.avatar}" alt="${u.username}" width="120" />
        </li>
    </c:forEach>
</ul>

<h1>${users[1].username}</h1>