<%-- 
    Document   : signup
    Created on : Jul 12, 2019, 10:44:03 AM
    Author     : bobbysmedley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
        <link rel="stylesheet" type="text/css" href="css/global.css">
        <link rel="stylesheet" type="text/css" href="css/signup.css">
    </head>
    <body>
        <h1>Sign-up form</h1>
        <form id="signupForm" method="post" action="/nbadProject/membership?action=signup">
            <label for="firstname">First Name</label>
            <input type="text" name="firstname" required>
            <br>
            <label for="lastname">Last Name</label>
            <input type="text" name="lastname" required>
            <br>
            <label for="email">Email</label>
            <input type="email" name="email" required>
            <br>
            <label for="username">Username</label>
            <input type="text" name="username" required>
            <br>
            <label for="password">Password</label>
            <input type="password" name="password" minlength="8" required>
            <br>
            <button type="submit" form="signupForm">Sign up</button>
        </form>        
    </body>
</html>
