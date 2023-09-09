<%-- 
    Document   : listReservation
    Created on : Sep 8, 2023, 9:42:11 AM
    Author     : Ngoc Thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/trip/" var="actionAdd" />
<c:url value="/trip/" var="actionUpdate" />
<c:url value="/trip/delete/" var="actionDelete" />

<!--<br/>
<form action="${actionAdd}">
    <button class="btn btn-warning" type="submit">Thêm người dùng mới</button>
</form>
<br/>-->

<ul>
    <c:forEach var="r" items="${reservations}">
        <li>
            <div>
                ${r.idReservation}
            </div>
            <div>
                ${r.timeReservation}
            </div>
            <div>
                ${r.numberSeatReservation}
            </div>
            <div>
                ${r.idUserReservation}
            </div>
            <div>
                ${r.idTripReservation}
            </div>
            
<!--            <div>
                <form action="${actionUpdate}${r.idReservation}">
                    <button class="btn btn-info" type="submit">Sửa thông tin</button>
                </form>
                <form action="${actionDelete}${r.idReservation}">
                    <button class="btn btn-danger" type="submit">Xoá</button>
                </form>
            </div>-->
        </li>
    </c:forEach>
</ul>
