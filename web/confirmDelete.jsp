<%-- 
    Document   : confirmDelete
    Created on : Jul 12, 2019, 11:54:16 AM
    Author     : bobbysmedley
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
        <link rel="stylesheet" type="text/css" href="css/global.css">
        <link rel="stylesheet" type="text/css" href="css/confirmDelete.css">
    </head>
    <body>
        <p>User <a href="/nbadProject/membership?action=logout">Logout</a></p>
        <h1>Are you sure you want to delete this product?</h1>
        <form id="deleteForm" method="post" action="/nbadProject/productManagement?action=deleteProduct&productCode=<c:out value='${requestScope.code}' />">
            <p><strong>Code: </strong><c:out value="${requestScope.code}" /></p>
            <p><strong>Description: </strong><c:out value="${requestScope.description}" /></p>
            <p><strong>Price: </strong><c:out value="${requestScope.price}" /></p>
        </form>
        <div id="buttons">
            <button type="submit" form="deleteForm">Yes</button>
            <button onclick="window.location.href = '/nbadProject/productManagement?action=displayProducts'">No</button>
        </div>
    </body>
</html>
