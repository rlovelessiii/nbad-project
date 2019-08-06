<%-- 
    Document   : products
    Author     : Richard Loveless III
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
        <link rel="stylesheet" type="text/css" href="css/global.css">
        <link rel="stylesheet" type="text/css" href="css/products.css">
    </head>
    <body>
        <p>User <a href="/nbadProject/membership?action=logout">Logout</a></p>
        <h1>Products</h1>
        <table border="1">
            <tr>
                <th class="code">Code</th>
                <th class="desc">Description</th>
                <th class="price">Price</th>
                <th class="edit">&nbsp;</th>
                <th class="delete">&nbsp;</th>
            </tr>
            <c:forEach var="product" items="${requestScope.products}">
                <tr>
                    <td>${product.getCode()}</td>
                    <td>${product.getDescription()}</td>
                    <td>$ ${product.getPrice()}</td>
                    <td><a href="/nbadProject/productManagement?action=deleteProduct&productCode=${product.getCode()}">Delete</a></td>
                    <td><a href="/nbadProject/productManagement?action=displayProduct&productCode=${product.getCode()}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
            <button onclick="window.location.href = '/nbadProject/productManagement?action=addProduct'">Add Product</button>
    </body>
</html>
