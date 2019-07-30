<%-- 
    Document   : product
    Created on : Jul 12, 2019, 11:04:48 AM
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
        <link rel="stylesheet" type="text/css" href="css/product.css">
    </head>
    <body>
        <p>User <a href="/nbadProject/membership?action=logout">Logout</a></p>
        <h1>Product</h1>
        <form id="productForm" method="post" action="/nbadProject/productManagement?action=addProduct&productCode=<c:out value='${code}' />">
              <label for="code">Code:</label>
            <input type="text" name="code" class="text" value="<c:out value="${code}" />" required>
            <br>
            <label for="description" id="descriptionLabel">Description:</label>
            <textarea name="description" cols="30" rows="10"><c:out value="${description}" /></textarea>
            <br>
            <label for="price">Price:</label>
            <input name="price" type="number" step="0.01" min="0" class="text" value="<c:out value="${price}" />" required>
            <br>
        </form>
        <div id="buttons">
            <button type="submit" form="productForm">Update Product</button>
            <button onclick="window.location.href = '/nbadProject/productManagement?action=displayProducts'">View Products</button>
        </div>
    </body>
</html>
