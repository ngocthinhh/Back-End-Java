<%-- 
    Document   : listTrip
    Created on : Sep 7, 2023, 10:50:25 PM
    Author     : Ngoc Thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/trip/" var="actionAdd" />
<c:url value="/trip/" var="actionUpdate" />
<c:url value="/trip/delete/" var="actionDelete" />

<br/>
<form action="${actionAdd}">
    <button class="btn btn-warning" type="submit">Thêm người dùng mới</button>
</form>
<br/>
<ul>
    <c:forEach var="t" items="${trips}">
        <li>
            <div>
                ${t.idTrip}
            </div>
            <div>
                ${t.departureTimeTrip}
            </div>
            <div>
                ${t.priceTrip}
            </div>
            <div>
                ${t.numberSeatsTrip}
            </div>
            <div>
                ${t.idRouteTrip}
            </div>
            <div>
                ${t.idUserTrip}
            </div>
            <div>
                <form action="${actionUpdate}${t.idTrip}">
                    <button class="btn btn-info" type="submit">Sửa thông tin</button>
                </form>
                <form action="${actionDelete}${t.idTrip}">
                    <button class="btn btn-danger" type="submit">Xoá</button>
                </form>
            </div>
        </li>
    </c:forEach>
</ul>
