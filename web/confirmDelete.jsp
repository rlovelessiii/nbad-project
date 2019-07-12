<%-- 
    Document   : confirmDelete
    Created on : Jul 12, 2019, 11:54:16 AM
    Author     : bobbysmedley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
        <link rel="stylesheet" type="text/css" href="css/confirmDelete.css">
    </head>
    <body>
        <p>User <a href="" >Logout</a></p>
        <h1>Are you sure you want to delete this product?</h1>
        <form id="deleteForm">
            <label for="code" id="topLabel">Code:</label>
            <br>
            <label for="description" id="descriptionLabel">Description:</label>
            <br>
            <label for="price">Price:</label>
            <br>
            <div id="buttons">
                <button type="submit" form="deleteForm">Yes</button>
                <button type="submit" form="deleteForm">No</button>
            </div>
        </form>
    </body>
</html>
