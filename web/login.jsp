<%-- 
    Document   : login
    Created on : Jul 12, 2019, 9:24:59 AM
    Author     : bobbysmedley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
        <link rel="stylesheet" type="text/css" href="css/global.css">
        <link rel="stylesheet" type="text/css" href="css/login.css">
    </head>
    <body>
        <h1>Login</h1>
        <form id="loginForm" method="post" action="/nbadProject/membership?action=login">
            <label for="username">Email</label>
            <input type="text" name="email">
            <br>
            <label for="password">Password</label>
            <input type="password" name="password">
            <br>
            <button type="submit" form="loginForm">Login</button>
        </form>        
        <p><a href="/nbadProject/membership?action=signup">New user? Click here to register</a></p>    
    </body>
</html>
