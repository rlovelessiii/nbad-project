<%-- 
    Document   : products
    Author     : Richard Loveless III
--%>

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
        <p>User <a href="">Logout</a></p>
        <h1>Products</h1>
        <table border="1">
            <tr>
                <th class="code">Code</th>
                <th class="desc">Description</th>
                <th class="price">Price</th>
                <th class="edit">&nbsp;</th>
                <th class="delete">&nbsp;</th>
            </tr>
            <tr>
              <td class="code">8601</td>
              <td class="desc">86 (the band) - True Life Songs and Pictures</td>
              <td class="price">$15.95</td>
              <td class="edit" ><a href="/nbadProject/productManagement?action=displayProduct">Edit</a></td>
              <td class="delete"><a href="/nbadProject/productManagement?action=deleteProduct">Delete</a></td>
            </tr>
            <tr>
              <td class="code">pf01</td>
              <td class="desc">Paddlefoot - The first CD</td>
              <td class="price">$12.95</td>
              <td class="edit"><a href="/nbadProject/productManagement?action=displayProduct">Edit</a></td>
              <td class="delete"><a href="/nbadProject/productManagement?action=deleteProduct">Delete</a></td>
            </tr>
            <tr>
              <td class="code">pf02</td>
              <td class="desc">Paddlefoot - The second CD</td>
              <td class="price">$14.95</td>
              <td class="edit"\><a href="/nbadProject/productManagement?action=displayProduct">Edit</a></td>
              <td class="delete"><a href="/nbadProject/productManagement?action=deleteProduct">Delete</a></td>
            </tr>
            <tr>
              <td class="code">jr01</td>
              <td class="desc">Joe Rut - Genuine Wood Grained Finish</td>
              <td class="price">$14.95</td>
              <td class="edit"><a href="/nbadProject/productManagement?action=displayProduct">Edit</a></td>
              <td class="delete"><a href="/nbadProject/productManagement?action=deleteProduct">Delete</a></td>
            </tr>
        </table>
            <button onclick="window.location.href = '/nbadProject/productManagement?action=displayProduct'">Add Product</button>
    </body>
</html>
