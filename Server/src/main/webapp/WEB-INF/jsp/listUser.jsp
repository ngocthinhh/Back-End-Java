<%-- 
    Document   : listUser
    Created on : Sep 7, 2023, 11:24:17 AM
    Author     : Ngoc Thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/user/" var="actionAdd" />
<c:url value="/user/" var="actionUpdate" />
<c:url value="/user/delete/" var="actionDelete" />

<!--<div class="container">
    <br/>
    <form action="${actionAdd}">
        <button class="btn btn-warning" type="submit">Thêm người dùng mới</button>
    </form>
    <br/>
    
    <ul class="list-group">
        <c:forEach var="u" items="${users}">
            <li class="list-group-item">
                            <div>
                                <img src="${u.avatarUser}" alt="${u.usernameUser}" width="120" />
                            </div>
                <div>
                    ${u.idUser}
                </div>
                <div>
                    ${u.usernameUser}
                </div>
                <div>
                    ${u.passwordUser}
                </div>
                <div>
                    ${u.fullNameUser}
                </div>
                <div>
                    ${u.phoneNumberUser}
                </div>
                <div>
                    ${u.roleUser}
                </div>
                <div>
                    ${u.avatarUser}
                </div>
                <div>
                    <form action="${actionUpdate}${u.idUser}">
                        <button class="btn btn-info" type="submit">Sửa thông tin</button>
                    </form>
                    <form action="${actionDelete}${u.idUser}">
                        <button class="btn btn-danger" type="submit">Xoá</button>
                    </form>
                    <button class="btn btn-info" >
                    Sửa thông tin
                    </button>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>-->

<div class="container">
    <br/>
    <form action="${actionAdd}">
        <button class="btn btn-warning" type="submit">Thêm người dùng mới</button>
    </form>
    <br/>

    <div class="card-container">
        <c:forEach var="u" items="${users}">
            <div class="card">
                <!-- Hình ảnh người dùng (Nếu cần) -->
                <!-- <div>
                    <img src="${u.avatarUser}" alt="${u.usernameUser}" width="120" />
                </div> -->
                <div class="card-body">
                    <h5 class="card-title">ID: ${u.idUser}</h5>
                    <p class="card-text">Tên đăng nhập: ${u.usernameUser}</p>
                    <p class="card-text">Mật khẩu: ${u.passwordUser}</p>
                    <p class="card-text">Họ và tên: ${u.fullNameUser}</p>
                    <p class="card-text">Số điện thoại: ${u.phoneNumberUser}</p>
                    <p class="card-text">Vai trò: ${u.roleUser}</p>
                    <p class="card-text">Ảnh đại diện: ${u.avatarUser}</p>
                    <div class="card-buttons">
                        <form action="${actionUpdate}${u.idUser}">
                            <button class="btn btn-info" type="submit">Sửa thông tin</button>
                        </form>
                        <form action="${actionDelete}${u.idUser}">
                            <button class="btn btn-danger" type="submit">Xoá</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>



