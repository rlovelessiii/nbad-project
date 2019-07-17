<%-- 
    Document   : product
    Created on : Jul 12, 2019, 11:04:48 AM
    Author     : bobbysmedley
--%>

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
        <p>User <a href="" >Logout</a></p>
        <h1>Product</h1>
        <form id="productForm">
            <label for="code">Code:</label>
            <input type="text" name="code" class="text">
            <br>
            <label for="description" id="descriptionLabel">Description:</label>
            <textarea name="description" cols="30" rows="10"></textarea>
            <br>
            <label for="price">Price:</label>
            <input type="text" name="price" class="text">
            <br>
            <div id="buttons">
                <button type="submit" form="productForm">Update Product</button>
                <button type="submit" form="productForm">View Products</button>
            </div>
        </form>
    </body>
</html>
