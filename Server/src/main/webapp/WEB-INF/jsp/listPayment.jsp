<%-- 
    Document   : listPayment
    Created on : Sep 8, 2023, 10:14:32 AM
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
    <c:forEach var="p" items="${payments}">
        <li>
            <div>
                ${p.idPayment}
            </div>
            <div>
                ${p.timePayment}
            </div>
            <div>
                ${p.typePayment}
            </div>
            <div>
                ${p.idUserPayment}
            </div>
            <div>
                ${p.idReservationPayment}
            </div>

            <!--            <div>
                                <form action="${actionUpdate}${p.idPayment}">
                                <button class="btn btn-info" type="submit">Sửa thông tin</button>
                            </form>
                                <form action="${actionDelete}${p.idPayment}">
                                <button class="btn btn-danger" type="submit">Xoá</button>
                            </form>
                        </div>-->
        </li>
    </c:forEach>
</ul>
