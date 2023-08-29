<%-- 
    Document   : base
    Created on : Aug 23, 2023, 12:07:35 AM
    Author     : Ngoc Thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title" />
        </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <!-- HEADER -->
            <tiles:insertAttribute name="header" />

            <!-- CONTENT -->
            <tiles:insertAttribute name="content" />

            <!-- FOOTER -->
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>
