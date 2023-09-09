<%-- 
    Document   : index
    Created on : Aug 22, 2023, 10:11:02 PM
    Author     : Ngoc Thinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul>
    <c:forEach var="u" items="${users}">
        <li>${u.idUser}</li>
        <li>${u.usernameUser}</li>
        <li>${u.passwordUser}</li>
        <li>${u.roleUser}</li>
        <li>${u.avatarUser}</li>
        <li>
            <img src="${u.avatarUser}" alt="${u.usernameUser}" width="120" />
        </li>
    </c:forEach>
</ul>