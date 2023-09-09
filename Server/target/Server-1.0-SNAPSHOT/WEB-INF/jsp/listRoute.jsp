<%-- 
    Document   : listRoute
    Created on : Sep 7, 2023, 1:37:12 PM
    Author     : Ngoc Thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/route/" var="actionAdd" />
<c:url value="/route/" var="actionUpdate" />
<c:url value="/route/delete/" var="actionDelete" />

<br/>
<form action="${actionAdd}">
    <button class="btn btn-warning" type="submit">Thêm tuyến mới</button>
</form>
<br/>

<ul>
    <c:forEach var="r" items="${routes}">
        <li>
            <div>
                ${r.idRoute}
            </div>
            <div>
                ${r.nameRoute}
            </div>
            <div>
                ${r.startingPointRoute}
            </div>
            <div>
                ${r.destinationRoute}
            </div>
            <div>
                <form action="${actionUpdate}${r.idRoute}">
                    <button class="btn btn-info" type="submit">Sửa thông tin</button>
                </form>
                <form action="${actionDelete}${r.idRoute}">
                    <button class="btn btn-danger" type="submit">Xoá</button>
                </form>
            </div>
        </li>
    </c:forEach>
</ul>
