<%-- 
    Document   : listFeedback
    Created on : Sep 8, 2023, 12:36:30 PM
    Author     : Ngoc Thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/trip/" var="actionAdd" />
<c:url value="/trip/" var="actionUpdate" />
<c:url value="/trip/delete/" var="actionDelete" />

<div class="container">
    <ul class="list-group">
        <c:forEach var="f" items="${feedbacks}">
            <li class="list-group-item">
                <div>
                    ${f.idFeedback}
                </div>
                <div>
                    ${f.textFeedback}
                </div>
                <div>
                    ${f.ratingFeedback}
                </div>
                <div>
                    ${f.idUserFeedback}
                </div>
                <div>
                    ${f.idTripFeedback}
                </div>

                <!--            <div>
                                        <form action="${actionUpdate}${f.idFeedback}">
                                    <button class="btn btn-info" type="submit">Sửa thông tin</button>
                                </form>
                                        <form action="${actionDelete}${f.idFeedback}">
                                    <button class="btn btn-danger" type="submit">Xoá</button>
                                </form>
                            </div>-->
            </li>
        </c:forEach>
    </ul>
</div>

